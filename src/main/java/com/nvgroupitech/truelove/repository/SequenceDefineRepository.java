package com.nvgroupitech.truelove.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.models.jpa.entities.SequenceDefineEntity;

@Repository
public interface SequenceDefineRepository extends JpaRepository<SequenceDefineEntity, UUID>, JpaSpecificationExecutor<SequenceDefineEntity>{
	SequenceDefineEntity getOneBySeqCode(String seqCode);
}
