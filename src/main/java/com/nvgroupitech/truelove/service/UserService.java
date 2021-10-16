package com.nvgroupitech.truelove.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;

public interface UserService {

	Page<UserDTO> getUsers(UserCriteria criteria, Pageable pageable);
	
	UserEntity signupNewUser(UserEntity user);

    Optional<UserEntity> findUserByEmail(String email);
    
    void updateOnboardStatus(boolean onboard,String username);

	void updateAvatar(UserEntity user);
}
