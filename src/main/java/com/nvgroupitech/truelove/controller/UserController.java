package com.nvgroupitech.truelove.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.common.util.PaginationUtil;
import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.service.UserService;

@RestController
@RequestMapping("/v1.0")
public class UserController {
	
	@Autowired
	private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<PageableObject<UserDTO>> getUsers(HttpServletRequest request, UserCriteria criteria, Pageable pageable) {
        
        Page<UserDTO> page = userService.getUsers(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/users");
        return new ResponseEntity<>(new PageableObject<>(page), headers, HttpStatus.OK);
    }

}
