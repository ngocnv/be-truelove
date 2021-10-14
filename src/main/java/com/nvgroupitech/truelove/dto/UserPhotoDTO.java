package com.nvgroupitech.truelove.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class UserPhotoDTO {

	private UUID photoId;

	private String photoUri;
	
	@NotBlank(message="{avatar.notblank}")	
	private String photoData;

	private String descrition;

	public UUID getPhotoId() {
		return photoId;
	}

	public void setPhotoId(UUID photoId) {
		this.photoId = photoId;
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

	public String getPhotoData() {
		return photoData;
	}

	public void setPhotoData(String photoData) {
		this.photoData = photoData;
	}
	
}
