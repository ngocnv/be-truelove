package com.nvgroupitech.truelove.service;

import java.util.List;

import com.nvgroupitech.truelove.domain.SequenceTrack;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceDefineEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceMakeEntity;
import com.nvgroupitech.truelove.models.jpa.entities.SequenceTrackEntity;




public interface SequenceService {

	SequenceDefineEntity getBySeqlCode(String seqCode);
	
	SequenceTrackEntity getBySeqCodeAndSegmentOnLock(String seqCode,String segment);
	
	SequenceTrackEntity createSequence(SequenceTrackEntity seq);
	
	SequenceTrackEntity updateSequence(SequenceTrackEntity seq);
	
	List<SequenceMakeEntity> getSequenceMakerList(String seqCode);
	
	SequenceTrackEntity getSequenceInfo(SequenceTrack sequenceTrackDTO) ;
	
	long next(SequenceTrack sequenceTrack);
}
