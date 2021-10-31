package com.nvgroupitech.truelove.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nvgroupitech.truelove.dto.CategoryItemDTO;
import com.nvgroupitech.truelove.models.jpa.entities.CategoryItemEntity;

@Mapper(componentModel = "spring", uses = {})
public interface CategoryItemMapper extends EntityMapper<CategoryItemDTO, CategoryItemEntity> {
	CategoryItemEntity toEntity(CategoryItemDTO dto);

	CategoryItemDTO toDto(CategoryItemEntity entity);

	List<CategoryItemDTO> toDtos(List<CategoryItemEntity> entities);

	List<CategoryItemEntity> toEntities(List<CategoryItemDTO> dtos);
}
