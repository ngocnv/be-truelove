package com.nvgroupitech.truelove.domain;

import java.io.Serializable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nvgroupitech.truelove.models.jpa.entities.SequenceDefineEntity;

public class SequenceTrack implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(SequenceTrack.class);
	
	private UUID sequenceTrackId;
	
	private String seqCode;

	private String seqSegment;

	private String seqDescription;
	
	private Long seqNo;
	
	private SequenceDefineEntity seqDef;
	
	private long currentValue = 1;
	private long maxValue = 0;

	public SequenceTrack(String seqCode, String seqSegment, SequenceDefineEntity seqDef) {
		this.seqCode = seqCode;
		this.seqSegment = seqSegment;
		this.seqDef = seqDef;
	}

	public SequenceTrack() {
	}
	
	
	public String getSeqCode() {
		return seqCode;
	}

	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}

	public String getSeqSegment() {
		return seqSegment;
	}

	public void setSeqSegment(String seqSegment) {
		this.seqSegment = seqSegment;
	}

	public String getSeqDescription() {
		return seqDescription;
	}

	public void setSeqDescription(String seqDescription) {
		this.seqDescription = seqDescription;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public SequenceDefineEntity getSeqDef() {
		return seqDef;
	}

	public void setSeqDef(SequenceDefineEntity seqDef) {
		this.seqDef = seqDef;
	}

	public long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(long currentValue) {
		this.currentValue = currentValue;
	}

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}

	public UUID getSequenceTrackId() {
		return sequenceTrackId;
	}

	public void setSequenceTrackId(UUID sequenceTrackId) {
		this.sequenceTrackId = sequenceTrackId;
	}
	
}