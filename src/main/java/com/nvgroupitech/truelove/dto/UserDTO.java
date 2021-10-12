
package com.nvgroupitech.truelove.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nvgroupitech.truelove.annotation.EnumNamePattern;
import com.nvgroupitech.truelove.enums.DatingType;
import com.nvgroupitech.truelove.enums.Gender;
import com.nvgroupitech.truelove.enums.LanguageCode;



public class UserDTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID userId;
	
	private String accessToken;
	
	private String username;

	@NotBlank(message="{fullname.notblank}")	
	@Size(min=3, max=255,message= "{fullname.size}")
	private String fullname;
	
	@NotBlank(message="{emailaddress.notblank}")	
	@Size(min=3,max=255,message="{emailladdress.size}")
	private String emailAddress;

	@NotBlank(message="{mobile.notblank}")	
	@Size(min=8,max=20,message="{mobile.size}")
	private String mobile;

	@NotBlank(message="{password.notblank}")	
	@Size(min=3,max=255)
	private String password;

	@EnumNamePattern(regexp = "SEEKER|PROVIDER",message="{datingtype.notblank}")
	private DatingType datingType;

	@EnumNamePattern(regexp = "EN|VN",message="{datingtype.notblank}")
	private LanguageCode languageCode;

	@NotBlank(message="{birthdate.notblank}")	
	@Size(min = 8,max=8,message="{birthdate.size}")
	private String birthdate;

	@EnumNamePattern(regexp = "MALE|FEMALE",message="{gender.notblank}")
	private Gender gender;
	
	@NotBlank(message="{avatar.notblank}")	
	private String avatar;
	
	private boolean isOnboard;
	

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DatingType getDatingType() {
		return datingType;
	}

	public void setDatingType(DatingType datingType) {
		this.datingType = datingType;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public boolean isOnboard() {
		return isOnboard;
	}

	public void setOnboard(boolean isOnboard) {
		this.isOnboard = isOnboard;
	}
    
}
