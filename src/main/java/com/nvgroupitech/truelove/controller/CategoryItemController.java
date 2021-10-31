package com.nvgroupitech.truelove.controller;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.common.PageableObject;
import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.dto.CategoryItemDTO;
import com.nvgroupitech.truelove.models.jpa.entities.CategoryItemEntity;
import com.nvgroupitech.truelove.service.CategoryItemService;
import com.nvgroupitech.truelove.service.mapper.CategoryItemMapper;

@RestController
@RequestMapping("/v1.0")
public class CategoryItemController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryItemController.class);

	@Autowired
	private CategoryItemService categoryItemService;
	
	@Autowired
	private CategoryItemMapper categoryItemMapper;

	@GetMapping(path = "/categoryItems")
	public ResponseEntity<PageableObject<CategoryItemDTO>> getItems(CategoryItemCriteria criteria, Pageable pageable) {
		
		Page<CategoryItemDTO> page = categoryItemService.getItems(criteria, pageable);
		
		return new ResponseEntity<>(new PageableObject<>(page), HttpStatus.OK);

	}
	
	@GetMapping(path = "/categoryItems/{itemId}")
	public ResponseEntity<CategoryItemDTO> getItemDetail(@PathVariable("itemId") UUID itemId) {
		Optional<CategoryItemEntity> itemDetail = categoryItemService.getItem(itemId);
		return new ResponseEntity<>(itemDetail.isPresent() ? categoryItemMapper.toDto(itemDetail.get()):null, HttpStatus.OK);
	}
}
