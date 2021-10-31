package com.nvgroupitech.truelove.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.dto.CategoryItemDTO;

public interface CategoryItemService {

	Page<CategoryItemDTO> getItems(CategoryItemCriteria criteria, Pageable pageable);

}
