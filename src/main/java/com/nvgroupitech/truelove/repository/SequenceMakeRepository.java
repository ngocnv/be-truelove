package com.nvgroupitech.truelove.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.models.jpa.entities.SequenceMakeEntity;

@Repository
public interface SequenceMakeRepository extends JpaRepository<SequenceMakeEntity, UUID>, JpaSpecificationExecutor<SequenceMakeEntity>{
	
	List<SequenceMakeEntity> findAllBySeqCodeOrderBySortOrderAsc(String seqCode);
}
