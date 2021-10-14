package com.nvgroupitech.truelove.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.dto.UserPhotoDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserPhotoEntity;
import com.nvgroupitech.truelove.repository.UserPhotoRepository;
import com.nvgroupitech.truelove.service.UserPhotoService;
import com.nvgroupitech.truelove.service.mapper.UserPhotoMapper;

@Service
public class UserPhotoServiceImpl implements UserPhotoService {

	@Autowired
	private UserPhotoRepository userPhotoRepository;
	
	@Autowired
	private UserPhotoMapper userPhotoMapper;
	
	@Override
	public Page<UserPhotoDTO> getPhotoForUser(UUID userId, UserPhotoCriteria criteria, Pageable pageable) {
		Page<UserPhotoEntity> pageData = userPhotoRepository.findByUserId(userId,criteria,pageable);
		Page<UserPhotoDTO> page = pageData.map(photo->{
            UserPhotoDTO photoDTO = userPhotoMapper.toDto(photo);
            return photoDTO;
		});
		return page == null ? new PageImpl<>(new ArrayList<>(), pageable, 0) : page;
	}

	@Override
	@Transactional
	public UserPhotoEntity savePhoto(UserPhotoEntity userphoto) {
		return userPhotoRepository.save(userphoto);
	}

}
