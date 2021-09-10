package com.nvgroupitech.truelove.service;

import java.util.UUID;

import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;

public interface KeycloakService {
	
	UserEntity createUser(UserEntity user);
	
	public int deleteUser(UUID keycloakId);
}
