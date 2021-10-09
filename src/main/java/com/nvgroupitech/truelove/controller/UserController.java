package com.nvgroupitech.truelove.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.nvgroupitech.truelove.dto.UserAuthDTO;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.enums.ResultState;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.service.FileService;
import com.nvgroupitech.truelove.service.KeycloakService;
import com.nvgroupitech.truelove.service.UserService;
import com.nvgroupitech.truelove.service.mapper.UserMapper;
import com.nvgroupitech.truelove.utils.ApiUtil;
import com.nvgroupitech.truelove.utils.HttpUtil;
import com.nvgroupitech.truelove.utils.JsonUtils;
import com.nvgroupitech.truelove.utils.SeqUtil;
import com.nvgroupitech.truelove.validator.UserValidator;


@RestController
@RequestMapping("/v1.0")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	  
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
	
	@Value("${spring.security.oauth2.client.provider.keycloak.token-uri}")
	private String tokenUri;
	
	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
	private String clientId;
	
	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
	private String clientSecret;
	
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
					ApiUtil.getErrorMessage(UserDTO.class, errors),HttpStatus.BAD_REQUEST);
    	}
    	userDTO.setUsername(SeqUtil.genSeq("USERCODE"));
     	
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
    	user.setOnboard(false);
    	user = userService.signupNewUser(user);
    	UserDTO response = userMapper.toDto(user);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path="/users:auth")
    public ResponseEntity<UserDTO> authUser(HttpServletRequest request,UserAuthDTO userAuth, Errors errors ) throws Exception{
    	// Call to Keycloak to verify username/password and get token
    	// Get user info;
    	Optional<UserEntity> user = userService.findUserByEmail(userAuth.getEmail());
    	if(!user.isPresent()) {
    		throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(),ErrorMessages.E0003,LocaleContextHolder.getLocale());
    	}
    	
		String originalString=clientId+":"+clientSecret;
		String encodeString=new String(Base64.getEncoder().encode(originalString.getBytes()));
		Map<String,String> headers = new HashMap<>();
		headers.put("Authorization", "Basic "+encodeString);
		
		Map<String,String> formParams= new HashMap<>();
		formParams.put("grant_type","password");
		formParams.put("username", user.get().getUsername());
		formParams.put("password",userAuth.getPassword());
		
    	Map<String,String> response=HttpUtil.request(tokenUri, "POST",headers,formParams);
    	if(!response.get("statusCode").equals("200")) {
    		logger.info(response.get("body"));
    		logger.info(response.get("statusCode"));
    		throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(),ErrorMessages.E0003,LocaleContextHolder.getLocale());
    	}
    	
    	// Parse token
    	Map<String,Object> json= JsonUtils.parse(response.get("body"));
    	String token=(String) json.get("access_token");
    	
    	
    	UserDTO userDTO= userMapper.toDto(user.get());
    	userDTO.setAccessToken(token);
    	userDTO.setPassword(null);
    	userService.updateOnboardStatus(true, user.get().getUsername());
    	return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
