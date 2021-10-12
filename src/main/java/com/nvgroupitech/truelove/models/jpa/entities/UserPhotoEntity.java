package com.nvgroupitech.truelove.models.jpa.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_photo")
public class UserPhotoEntity extends CommonAudit{

	private static final long serialVersionUID = -8647874854989434089L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "photo_id")
    private UUID photoId;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = UserEntity.class)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private UserEntity user;
	
	@Column(name = "photo_uri")
	private String photoUri;
	
	@Column(name="description")
	private String descrition;

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
}
