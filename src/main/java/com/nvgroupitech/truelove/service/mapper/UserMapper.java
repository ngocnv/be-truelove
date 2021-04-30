package com.nvgroupitech.truelove.service.mapper;


import java.util.List;
import org.mapstruct.Mapper;
import com.nvgroupitech.truelove.dto.UserDTO;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, UserEntity> {

    UserEntity toEntity(UserDTO dto);

    UserDTO toDto(UserEntity userEntity);
	
    List<UserDTO> toDtos(List<UserEntity> UserEntity);
    
    List<UserEntity> toEntities(List<UserDTO> userDTOS);
}
