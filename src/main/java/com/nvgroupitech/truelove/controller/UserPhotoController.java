package com.nvgroupitech.truelove.controller;


import java.io.ByteArrayInputStream;

import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.common.util.PaginationUtil;
import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.dto.UserPhotoDTO;
import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.models.jpa.entities.UserPhotoEntity;
import com.nvgroupitech.truelove.service.FileService;
import com.nvgroupitech.truelove.service.UserPhotoService;
import com.nvgroupitech.truelove.service.UserService;
import com.nvgroupitech.truelove.service.mapper.UserPhotoMapper;
import com.nvgroupitech.truelove.utils.utils.JwtTokenUtils;

@RestController
@RequestMapping("/v1.0")
public class UserPhotoController {
	private static final Logger logger = LoggerFactory.getLogger(UserPhotoController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPhotoService userPhotoService;
	
	@Value("${spring.security.oauth2.client.provider.keycloak.token-uri}")
	private String tokenUri;
	
	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
	private String clientId;
	
	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
	private String clientSecret;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserPhotoMapper photoMapper;
    
    @GetMapping(path = "/users/{userId}/photos")
    public ResponseEntity<PageableObject<UserPhotoDTO>> getUserPhoto(HttpServletRequest request,@PathVariable("userId") UUID userId,UserPhotoCriteria criteria, Pageable pageable) throws JsonMappingException, JsonProcessingException {
    	JwtAuthenticationToken  authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        // Get ID Token Value
        String tokenValue = authentication.getToken().getTokenValue();
    	Map<String,Object> tokenAttributeMap= JwtTokenUtils.extract(tokenValue);
    	String email = (String) tokenAttributeMap.get("email");
    	Optional<UserEntity> user= userService.findUserByEmail(email);
    	if(!user.isPresent() || !user.get().getUserId().equals(userId)) {
    		throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(),ErrorMessages.E0003,LocaleContextHolder.getLocale());
    	}
     
        Page<UserPhotoDTO> page = userPhotoService.getPhotoForUser(userId,criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/users");
        return new ResponseEntity<>(new PageableObject<>(page), headers, HttpStatus.OK);
    }
    
    @PostMapping(path = "/users/{userId}/photos:upload")
    public ResponseEntity<UserPhotoDTO> uploadPhoto(@PathVariable("userId") UUID userId,@RequestBody UserPhotoDTO photo) throws Exception{
    	JwtAuthenticationToken  authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        // Get ID Token Value
        String tokenValue = authentication.getToken().getTokenValue();
    	Map<String,Object> tokenAttributeMap= JwtTokenUtils.extract(tokenValue);
    	String email = (String) tokenAttributeMap.get("email");
    	Optional<UserEntity> user= userService.findUserByEmail(email);
    	if(!user.isPresent() || !user.get().getUserId().equals(userId)) {
    		throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(),ErrorMessages.E0003,LocaleContextHolder.getLocale());
    	}
  
    	// data:/image/png;base64,*
    	String imageRegex="^data:image\\/([A-Za-z]+);base64,(.*)$";
    	
    	Pattern r = Pattern.compile(imageRegex);
    	String imageString=null;
    	Matcher m = r.matcher(photo.getPhotoData());
    	String imageExtension=null;
    	if(m.find()) {
    		imageExtension=m.group(1);
    		imageString=m.group(2);
    	}
    	String uploadUrl = "/okm:root/upload/truelove";
    	byte[] imageByte = Base64.getDecoder().decode(imageString);
    	ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
    	Map<String,String> result= fileService.fileUploadToOpenKM(uploadUrl, "user"+"."+imageExtension, bis);

    	bis.close();
    	
    	UserPhotoEntity photoEntity = new  UserPhotoEntity();
    	photoEntity.setUser(user.get());
    	photoEntity.setPhotoUri(result.get("path"));
    	
    	
    	return new ResponseEntity<>(photoMapper.toDto(userPhotoService.savePhoto(photoEntity)), HttpStatus.OK);
    }
    

}
