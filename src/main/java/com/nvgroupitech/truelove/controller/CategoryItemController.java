package com.nvgroupitech.truelove.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.dto.CategoryItemDTO;
import com.nvgroupitech.truelove.service.CategoryItemService;

@RestController
@RequestMapping("/v1.0")
public class CategoryItemController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryItemController.class);

	@Autowired
	private CategoryItemService categoryItemService;

	@GetMapping(path = "/categoryItems")
	public ResponseEntity<PageableObject<CategoryItemDTO>> getItems(CategoryItemCriteria criteria, Pageable pageable) {
		Page<CategoryItemDTO> page = categoryItemService.getItems(criteria, pageable);
		
		return new ResponseEntity<>(new PageableObject<>(page), HttpStatus.OK);

	}
}
