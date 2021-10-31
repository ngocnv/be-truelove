package com.nvgroupitech.truelove.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.criteria.CategoryItemCriteria;
import com.nvgroupitech.truelove.models.jpa.entities.CategoryItemEntity;

@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItemEntity, UUID>, JpaSpecificationExecutor<CategoryItemEntity>{
	
	@Query("select distinct i from CategoryItemEntity i where (:#{#criteria.category.equals} IS NULL OR i.category = :#{T(com.nvgroupitech.truelove.enums.Category).valueOf(#criteria.category.equals)} AND (:#{#criteria.name.contains} IS NOT NULL AND (:#{#criteria.name.contains} <> '' AND i.name like %:#{#criteria.name.contains}%)))")
	Page<CategoryItemEntity> findByCategory(CategoryItemCriteria criteria, Pageable pageable);
}
