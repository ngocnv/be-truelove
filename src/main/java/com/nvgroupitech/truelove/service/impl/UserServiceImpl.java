package com.nvgroupitech.truelove.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;
import com.nvgroupitech.truelove.repository.UserRepository;
import com.nvgroupitech.truelove.service.UserService;
import com.nvgroupitech.truelove.service.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Page<UserDTO> getUsers(UserCriteria criteria, Pageable pageable) {
		Page<UserEntity> pageData = userRepository.findAllByCriteria(criteria,pageable);
		Page<UserDTO> page = pageData.map(userEntity -> {
	                    UserDTO userDTO = userMapper.toDto(userEntity);
	                    return userDTO;
	                });
	    return page == null ? new PageImpl<>(new ArrayList<>(), pageable, 0) : page;
	}
	
	public Optional<UserEntity> findUserByEmail(String email) {
		return userRepository.findOneByEmailAddress(email);
		
	}

	@Override
	public UserEntity signupNewUser(UserEntity user) {
		UserEntity u = userRepository.saveAndFlush(user);
		return u;
	}

	@Override
	@Transactional
	public void updateOnboardStatus(boolean onboard,String username) {
		userRepository.updateOnboardStatus(onboard, username);
	}

	@Override
	public void updateAvatar(UserEntity user) {
		userRepository.save(user);
	}

	@Override
	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}
	
}
