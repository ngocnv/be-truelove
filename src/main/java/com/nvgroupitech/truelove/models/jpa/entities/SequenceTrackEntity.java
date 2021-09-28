package com.nvgroupitech.truelove.models.jpa.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sequence_track")
public class SequenceTrackEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "sequence_track_id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID sequenceTrackId;

	@Column(name="seq_code")
	private String seqCode;

	@Column(name="seq_segment")
	private String seqSegment;

	@Column(name="seq_description")
	private String seqDescription;

	@Column(name="seq_no")
	private Long seqNo;
	
	public UUID getSequenceTrackId() {
		return sequenceTrackId;
	}

	public void setSequenceTrackId(UUID sequenceTrackId) {
		this.sequenceTrackId = sequenceTrackId;
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
	
}