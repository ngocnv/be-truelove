package com.nvgroupitech.truelove.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.dto.UserPhotoDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.models.jpa.entities.UserPhotoEntity;

public interface UserPhotoService {

	Page<UserPhotoDTO> getPhotoForUser(UUID userId, UserPhotoCriteria criteria, Pageable pageable);
	
	UserPhotoEntity savePhoto(UserPhotoEntity userphoto);
	
	Optional<UserPhotoEntity> findPhotoByIdAndUser(UUID photoId,UserEntity user);

	void deletePhoto(UUID photoId);
}
