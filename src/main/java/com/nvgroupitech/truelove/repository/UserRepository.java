
package com.nvgroupitech.truelove.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.criteria.UserCriteria;
import com.nvgroupitech.truelove.models.jpa.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>, JpaSpecificationExecutor<UserEntity> {
    UserEntity findByUserId(UUID userId);
    
    @Query("select distinct u from UserEntity u where (:#{#criteria.name.contains} is null or upper(u.fullname)  like %:#{T(org.apache.commons.lang3.StringUtils).upperCase(#criteria.name.contains)}% )")
	Page<UserEntity> findAllByCriteria(UserCriteria criteria, Pageable pageable);

    Optional <UserEntity> findOneByEmailAddress(String email);
}

