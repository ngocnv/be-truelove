package com.nvgroupitech.truelove.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.dto.UserPhotoDTO;

public interface UserPhotoService {

	Page<UserPhotoDTO> getPhotoForUser(UUID userId, UserPhotoCriteria criteria, Pageable pageable);
	
}
