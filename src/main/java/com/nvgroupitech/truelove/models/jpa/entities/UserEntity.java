
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

    @Column(name="avatar")
    private String avatar;
    
   

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


}
