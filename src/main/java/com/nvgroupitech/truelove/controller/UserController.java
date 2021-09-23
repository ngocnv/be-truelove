package com.nvgroupitech.truelove.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.common.util.PaginationUtil;
import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.dto.BaseDTO;
import com.nvgroupitech.truelove.dto.ErrorDTO;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.enums.ResultState;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.service.FileService;
import com.nvgroupitech.truelove.service.KeycloakService;
import com.nvgroupitech.truelove.service.UserService;
import com.nvgroupitech.truelove.service.mapper.UserMapper;
import com.nvgroupitech.truelove.utils.ApiUtil;
import com.nvgroupitech.truelove.validator.UserValidator;

@RestController
@RequestMapping("/v1.0")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KeycloakService keycloakService;
	
	@Autowired
	private UserValidator validator;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private UserMapper userMapper;
	
	@InitBinder(value="userDTO")
	protected void initUserBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

    @GetMapping(path = "/users")
    public ResponseEntity<PageableObject<UserDTO>> getUsers(HttpServletRequest request, UserCriteria criteria, Pageable pageable) {
        
        Page<UserDTO> page = userService.getUsers(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/users");
        return new ResponseEntity<>(new PageableObject<>(page), headers, HttpStatus.OK);
    }
    
  
    @PostMapping(path="/users")
    @Transactional()
    public ResponseEntity<UserDTO> createUser(HttpServletRequest request,@Valid @RequestBody UserDTO userDTO, Errors errors ) throws Exception{
    	if(errors.hasErrors()) {
    		return new ResponseEntity<>(
					ApiUtil.getErrorMessage(UserDTO.class, errors),HttpStatus.OK);
    	}
    	
     	
    	UserEntity user = keycloakService.createUser(userMapper.toEntity(userDTO)); 
    	ApiUtil.putLocalContext(CommonConstant.KEYCLOAK_ID, user.getKeycloakId());
    	
    	
    	// data:/image/png;base64,*
    	String avatarImageRegex="^data:\\/image\\/([A-Za-z]+);base64,(.*)$";
    	
    	Pattern r = Pattern.compile(avatarImageRegex);
    	String imageString=null;
    	Matcher m = r.matcher(userDTO.getAvatar());
    	String imageExtension=null;
    	if(m.find()) {
    		imageExtension=m.group(1);
    		imageString=m.group(2);
    	}
        
    
    	byte[] imageByte = Base64.getDecoder().decode(imageString);
    	ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
    	BufferedImage image = ImageIO.read(bis);
    	
    	bis.close();
    	
    	File outputfile = File.createTempFile("avatar", "."+imageExtension);
    	String path= outputfile.getAbsolutePath();
    	ImageIO.write(image, imageExtension, outputfile);
    	String uploadUrl = "/okm:root/upload/truelove";
    	Map<String,String> result= fileService.fileUploadToOpenKM(uploadUrl, "avatar"+"."+imageExtension, new FileInputStream(new File(path)));
    	user.setAvatar(result.get("path"));
    	user = userService.signupNewUser(user);
    	UserDTO response = userMapper.toDto(user);
    	response.setResult(ResultState.S);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
