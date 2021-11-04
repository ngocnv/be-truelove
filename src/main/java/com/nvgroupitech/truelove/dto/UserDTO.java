
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
import com.nvgroupitech.truelove.enums.Literacy;



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
	
	private String jobTitle;
	
	
	private String company;
	
	private String university;
	
	private String postUniversity;
	
	private Literacy literacy;
	
	private String introduction;
	
	private Boolean isOnboard;
	

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

	public Boolean isOnboard() {
		return isOnboard;
	}

	public void setOnboard(Boolean isOnboard) {
		this.isOnboard = isOnboard;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPostUniversity() {
		return postUniversity;
	}

	public void setPostUniversity(String postUniversity) {
		this.postUniversity = postUniversity;
	}

	public Literacy getLiteracy() {
		return literacy;
	}

	public void setLiteracy(Literacy literacy) {
		this.literacy = literacy;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Boolean getOnboard() {
		return isOnboard;
	}

	public void setIsOnboard(Boolean isOnboard) {
		this.isOnboard = isOnboard;
	}
    
}
