package com.nvgroupitech.truelove.repository;

import java.util.UUID;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nvgroupitech.truelove.models.jpa.entities.SequenceTrackEntity;


@Repository
public interface SequenceTrackRepository extends JpaRepository<SequenceTrackEntity, UUID>, JpaSpecificationExecutor<SequenceTrackEntity>{
	
	@Query("SELECT t FROM SequenceTrackEntity t WHERE t.seqCode=:seqCode AND t.seqSegment=:seqSegment")
	@Lock(LockModeType.PESSIMISTIC_READ)
	SequenceTrackEntity selectBySeqCodeAndSeqSegment(@Param("seqCode") String seqCode,  @Param("seqSegment") String seqSegment);
}
