package com.nvgroupitech.truelove.service.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.nvgroupitech.truelove.dto.SaveUserDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;


@Mapper(componentModel = "spring", uses = {})
public interface SaveUserMapper extends EntityMapper<SaveUserDTO, UserEntity> {

    UserEntity toEntity(SaveUserDTO dto);

    SaveUserDTO toDto(UserEntity userEntity);
	
    List<SaveUserDTO> toDtos(List<UserEntity> UserEntity);
    
    List<UserEntity> toEntities(List<SaveUserDTO> userDTOS);
}
