package com.nvgroupitech.truelove.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.dto.UserDTO;

public interface UserService {

	Page<UserDTO> getUsers(UserCriteria criteria, Pageable pageable);
}
