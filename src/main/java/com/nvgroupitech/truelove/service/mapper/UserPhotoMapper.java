package com.nvgroupitech.truelove.service.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.nvgroupitech.truelove.dto.UserPhotoDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserPhotoEntity;


@Mapper(componentModel = "spring", uses = {})
public interface UserPhotoMapper extends EntityMapper<UserPhotoDTO, UserPhotoEntity> {

    UserPhotoEntity toEntity(UserPhotoDTO dto);

    UserPhotoDTO toDto(UserPhotoEntity entity);
	
    List<UserPhotoDTO> toDtos(List<UserPhotoEntity> entities);
    
    List<UserPhotoEntity> toEntities(List<UserPhotoDTO> dtos);
}
