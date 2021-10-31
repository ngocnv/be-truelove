package com.nvgroupitech.truelove.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.dto.CategoryItemDTO;
import com.nvgroupitech.truelove.models.jpa.entities.CategoryItemEntity;

public interface CategoryItemService {

	Page<CategoryItemDTO> getItems(CategoryItemCriteria criteria, Pageable pageable);
	Optional<CategoryItemEntity> getItem(UUID itemId);
}
