
package com.nvgroupitech.truelove.repository;


import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.criteria.UserPhotoCriteria;
import com.nvgroupitech.truelove.models.jpa.entities.UserPhotoEntity;

@Repository
public interface UserPhotoRepository extends JpaRepository<UserPhotoEntity, UUID>, JpaSpecificationExecutor<UserPhotoEntity> {

	@Query("select distinct p from UserPhotoEntity p where p.user.userId=:userId and (:#{#criteria.photoUri.contains} is null or p.photoUri like %:#{#criteria.photoUri.contains}%)")
	Page<UserPhotoEntity> findByUserId(UUID userId, UserPhotoCriteria criteria, Pageable pageable);
   
}

