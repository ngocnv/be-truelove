
package com.nvgroupitech.truelove.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nvgroupitech.truelove.annotation.EnumNamePattern;
import com.nvgroupitech.truelove.enums.Gender;
import com.nvgroupitech.truelove.enums.Literacy;

public class SaveUserDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID userId;

	@NotBlank(message = "{fullname.notblank}")
	@Size(min = 3, max = 255, message = "{fullname.size}")
	private String fullname;

	@NotBlank(message = "{birthdate.notblank}")
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$")
	@Size(min = 8, max = 8, message = "{birthdate.size}")
	private String birthdate;

	@EnumNamePattern(regexp = "MALE|FEMALE", message = "{gender.notblank}")
	private Gender gender;

	private String jobTitle;

	private String company;

	private String university;

	private String postUniversity;

	@EnumNamePattern(regexp = "KEEP_SECRET|MIDDLE_SCHOOL|HIGH_SCHOOL|POST_SECONDARY_EDUCATION|POST_GRADUATION_EDUCATION", message = "{literacy.notblank}")
	private Literacy literacy;
	
	private String introduction;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}
