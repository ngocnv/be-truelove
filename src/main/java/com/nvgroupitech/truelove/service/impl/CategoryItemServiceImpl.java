package com.nvgroupitech.truelove.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.dto.CategoryItemDTO;
import com.nvgroupitech.truelove.models.jpa.entities.CategoryItemEntity;
import com.nvgroupitech.truelove.repository.CategoryItemRepository;
import com.nvgroupitech.truelove.service.CategoryItemService;
import com.nvgroupitech.truelove.service.mapper.CategoryItemMapper;

@Service
public class CategoryItemServiceImpl implements CategoryItemService {
	
	
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	
	@Autowired
	private CategoryItemMapper categoryItemMapper;


	public Page<CategoryItemDTO> getItems(CategoryItemCriteria criteria, Pageable pageable) {
		
		Page<CategoryItemEntity> pageData = categoryItemRepository.findByCategory(criteria,pageable);
		Page<CategoryItemDTO> page = pageData.map(photo->{
            CategoryItemDTO categoryItemDTO = categoryItemMapper.toDto(photo);
            return categoryItemDTO;
		});
		return page == null ? new PageImpl<>(new ArrayList<>(), pageable, 0) : page;
	}

	@Override
	public Optional<CategoryItemEntity> getItem(UUID itemId) {
		return categoryItemRepository.findById(itemId);
	}

}
