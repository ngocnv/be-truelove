package com.nvgroupitech.truelove.controller;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.dto.SaveUserDTO;
import com.nvgroupitech.truelove.dto.UserAuthDTO;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.service.FileService;
import com.nvgroupitech.truelove.service.KeycloakService;
import com.nvgroupitech.truelove.service.UserService;
import com.nvgroupitech.truelove.service.mapper.SaveUserMapper;
import com.nvgroupitech.truelove.service.mapper.UserMapper;
import com.nvgroupitech.truelove.utils.ApiUtil;
import com.nvgroupitech.truelove.utils.HttpUtil;
import com.nvgroupitech.truelove.utils.JsonUtils;
import com.nvgroupitech.truelove.utils.SeqUtil;
import com.nvgroupitech.truelove.utils.utils.JwtTokenUtils;
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
	
	@Autowired
	private SaveUserMapper saveUserMapper;

	@Value("${spring.security.oauth2.client.provider.keycloak.token-uri}")
	private String tokenUri;

	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
	private String clientSecret;

	@InitBinder(value = "userDTO")
	protected void initUserBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@PostMapping(path = "/users/{userId}:saveUser")
	@Transactional()
	public ResponseEntity<SaveUserDTO> saveUser(@PathVariable("userId") UUID userId,@Valid @RequestBody SaveUserDTO userDTO,Errors errors) throws JsonMappingException, JsonProcessingException {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(ApiUtil.getErrorMessage(SaveUserDTO.class, errors), HttpStatus.BAD_REQUEST);
		}
		JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		String tokenValue = authentication.getToken().getTokenValue();
		Map<String, Object> tokenAttributeMap = JwtTokenUtils.extract(tokenValue);
		String email = (String) tokenAttributeMap.get("email");
		Optional<UserEntity> user = userService.findUserByEmail(email);
		if (!user.isPresent() || !user.get().getUserId().equals(userId)) {
			throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(), ErrorMessages.E0003,
					LocaleContextHolder.getLocale());
		}
		user.get().setFullname(userDTO.getFullname());
		user.get().setBirthdate(userDTO.getBirthdate());
		user.get().setGender(userDTO.getGender());
		user.get().setJobTitle(userDTO.getJobTitle());
		user.get().setCompany(userDTO.getCompany());
		user.get().setUniversity(userDTO.getUniversity());
		user.get().setPostUniversity(userDTO.getPostUniversity());
		user.get().setLiteracy(userDTO.getLiteracy());
		user.get().setIntroduction(userDTO.getIntroduction());
		userService.saveUser(user.get());
		SaveUserDTO response = saveUserMapper.toDto(user.get());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/users")
	@Transactional()
	public ResponseEntity<UserDTO> createUser(HttpServletRequest request, @Valid @RequestBody UserDTO userDTO,
			Errors errors) throws Exception {
		if (errors.hasErrors()) {
			return new ResponseEntity<>(ApiUtil.getErrorMessage(UserDTO.class, errors), HttpStatus.BAD_REQUEST);
		}
		userDTO.setUsername(SeqUtil.genSeq("USERCODE"));

		UserEntity user = keycloakService.createUser(userMapper.toEntity(userDTO));

		ApiUtil.putLocalContext(CommonConstant.KEYCLOAK_ID, user.getKeycloakId());

		// data:/image/png;base64,*
		String avatarImageRegex = "^data:image\\/([A-Za-z]+);base64,(.*)$";

		Pattern r = Pattern.compile(avatarImageRegex);
		String imageString = null;
		Matcher m = r.matcher(userDTO.getAvatar());
		String imageExtension = null;
		if (m.find()) {
			imageExtension = m.group(1);
			imageString = m.group(2);
		}

		byte[] imageByte = Base64.getDecoder().decode(imageString);
		ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);

		String uploadUrl = "/okm:root/upload/truelove";
		Map<String, String> result = fileService.uploadFileToOpenKM(uploadUrl, "avatar" + "." + imageExtension, bis);
		bis.close();
		user.setAvatar(result.get("path"));
		user.setOnboard(false);
		user = userService.signupNewUser(user);
		UserDTO response = userMapper.toDto(user);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/users:auth")
	public ResponseEntity<UserDTO> authUser(UserAuthDTO userAuth, Errors errors) throws Exception {
		// Call to Keycloak to verify username/password and get token
		// Get user info;
		Optional<UserEntity> user = userService.findUserByEmail(userAuth.getEmail());
		if (!user.isPresent()) {
			throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(), ErrorMessages.E0003,
					LocaleContextHolder.getLocale());
		}

		String originalString = clientId + ":" + clientSecret;
		String encodeString = new String(Base64.getEncoder().encode(originalString.getBytes()));
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Basic " + encodeString);

		Map<String, String> formParams = new HashMap<>();
		formParams.put("grant_type", "password");
		formParams.put("username", user.get().getUsername());
		formParams.put("password", userAuth.getPassword());

		Map<String, String> response = HttpUtil.request(tokenUri, "POST", headers, formParams);
		if (!response.get("statusCode").equals("200")) {
			logger.info(response.get("body"));
			logger.info(response.get("statusCode"));
			throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(), ErrorMessages.E0003,
					LocaleContextHolder.getLocale());
		}

		// Parse token
		Map<String, Object> json = JsonUtils.parse(response.get("body"));
		String token = (String) json.get("access_token");

		UserDTO userDTO = userMapper.toDto(user.get());
		userDTO.setAccessToken(token);
		userDTO.setPassword(null);
		userService.updateOnboardStatus(true, user.get().getUsername());
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@PostMapping(path = "/users/{userId}:updateAvatar")
	public ResponseEntity<UserDTO> updateAvatar(@PathVariable("userId") UUID userId, @RequestBody UserDTO userDTO,
			Errors errors) throws Exception {
		JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		// Get ID Token Value
		String tokenValue = authentication.getToken().getTokenValue();
		Map<String, Object> tokenAttributeMap = JwtTokenUtils.extract(tokenValue);
		String email = (String) tokenAttributeMap.get("email");
		Optional<UserEntity> user = userService.findUserByEmail(email);
		if (!user.isPresent() || !user.get().getUserId().equals(userId)) {
			throw new ApiRuntimeException(ErrorMessages.E0003.getErrorDefaultMsgCd(), ErrorMessages.E0003,
					LocaleContextHolder.getLocale());
		}

		// data:/image/png;base64,*
		String imageRegex = "^data:image\\/([A-Za-z]+);base64,(.*)$";

		Pattern r = Pattern.compile(imageRegex);
		String imageString = null;
		Matcher m = r.matcher(userDTO.getAvatar());
		String imageExtension = null;
		if (m.find()) {
			imageExtension = m.group(1);
			imageString = m.group(2);
		}
		String uploadUrl = "/okm:root/upload/truelove";
		byte[] imageByte = Base64.getDecoder().decode(imageString);
		ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		Map<String, String> result = fileService.uploadFileToOpenKM(uploadUrl, "avatar" + "." + imageExtension, bis);
		bis.close();

		// Delete old avatar
		try {
			Map deleteFile = fileService.deleteFile(user.get().getAvatar());
		} catch (com.openkm.sdk4j.exception.PathNotFoundException e) {
			logger.warn("photo has been deleted");
		}
		user.get().setAvatar(result.get("path"));
		userService.updateAvatar(user.get());

		UserDTO response = new UserDTO();
		response.setAvatar(result.get("path"));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
