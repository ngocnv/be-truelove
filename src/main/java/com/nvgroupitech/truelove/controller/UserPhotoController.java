package com.nvgroupitech.truelove.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.common.util.PaginationUtil;
import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.dto.UserPhotoDTO;
import com.nvgroupitech.truelove.service.UserPhotoService;


@RestController
@RequestMapping("/v1.0")
public class UserPhotoController {
	private static final Logger logger = LoggerFactory.getLogger(UserPhotoController.class);

	
	@Autowired
	private UserPhotoService userPhotoService;
    
    @GetMapping(path = "/users/{userId}/photos")
    public ResponseEntity<PageableObject<UserPhotoDTO>> getUserPhoto(HttpServletRequest request,@PathVariable("userId") UUID userId,UserPhotoCriteria criteria, Pageable pageable) {
        
        Page<UserPhotoDTO> page = userPhotoService.getPhotoForUser(userId,criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/users");
        return new ResponseEntity<>(new PageableObject<>(page), headers, HttpStatus.OK);
    }

}
