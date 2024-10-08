
package com.nvgroupitech.truelove.models.jpa.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.nvgroupitech.truelove.enums.DatingType;
import com.nvgroupitech.truelove.enums.Gender;
import com.nvgroupitech.truelove.enums.LanguageCode;
import com.nvgroupitech.truelove.enums.Literacy;

@Entity
@Table(name = "users")
public class UserEntity extends CommonAudit implements Serializable {

	private static final long serialVersionUID = -5494794506198264824L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private UUID userId;
	
	@Column(name="keycloak_id")
	private UUID keycloakId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dating_type")
    @Enumerated(EnumType.STRING)
	private DatingType datingType;

    @Column(name = "last_session")
    private Instant lastSession;

    @Column(name = "language_code")
    @Enumerated(EnumType.STRING)
    private LanguageCode languageCode;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name="job_title")
    private String jobTitle;
    
    @Column(name="company")
    private String company;
    
    @Column(name="university")
    private String university;
    
    @Column(name="post_university")
    private String postUniversity;
    
    @Column(name="literacy")
    @Enumerated(EnumType.STRING)
    private Literacy literacy;

    @Column(name="introduction")
    private String introduction;
    
    @Column(name="avatar")
    private String avatar;
    
    @Column(name="is_onboard")
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

	public Instant getLastSession() {
		return lastSession;
	}

	public void setLastSession(Instant lastSession) {
		this.lastSession = lastSession;
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
	
	public UUID getKeycloakId() {
		return keycloakId;
	}

	public void setKeycloakId(UUID keycloakId) {
		this.keycloakId = keycloakId;
	}

	public boolean isOnboard() {
		return isOnboard;
	}

	public void setOnboard(boolean isOnboard) {
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

}
