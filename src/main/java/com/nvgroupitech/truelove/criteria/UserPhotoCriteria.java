package com.nvgroupitech.truelove.criteria;

import com.nvgroupitech.truelove.dto.filter.StringFilter;

public class UserPhotoCriteria {
	private StringFilter photoUri;

	public StringFilter getPhotoUri() {
		if(photoUri == null) {
			photoUri = new StringFilter();
		}
		return photoUri;
	}

	public void setPhotoUri(StringFilter photoUri) {
		this.photoUri = photoUri;
	}
	
}
