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
@Table(name="sequence_define")
public class SequenceDefineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sequence_define_id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID sequenceDefineId;
	
	@Column(name="seq_code")
	private String seqCode;

	@Column(name="seq_build_ind")
	private String seqBuildInd;

	@Column(name="seq_cache_size")
	private Long seqCacheSize;

	@Column(name="seq_description")
	private String seqDescription;

	@Column(name="seq_init_value")
	private Long seqInitValue;

	@Column(name="seq_length")
	private Long seqLength;

	@Column(name="seq_max_value")
	private Long seqMaxValue;

	public String getSeqCode() {
		return seqCode;
	}

	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}

	public String getSeqBuildInd() {
		return seqBuildInd;
	}

	public void setSeqBuildInd(String seqBuildInd) {
		this.seqBuildInd = seqBuildInd;
	}

	public Long getSeqCacheSize() {
		return seqCacheSize;
	}

	public void setSeqCacheSize(Long seqCacheSize) {
		this.seqCacheSize = seqCacheSize;
	}

	public String getSeqDescription() {
		return seqDescription;
	}

	public void setSeqDescription(String seqDescription) {
		this.seqDescription = seqDescription;
	}

	public Long getSeqInitValue() {
		return seqInitValue;
	}

	public void setSeqInitValue(Long seqInitValue) {
		this.seqInitValue = seqInitValue;
	}

	public Long getSeqLength() {
		return seqLength;
	}

	public void setSeqLength(Long seqLength) {
		this.seqLength = seqLength;
	}

	public Long getSeqMaxValue() {
		return seqMaxValue;
	}

	public void setSeqMaxValue(Long seqMaxValue) {
		this.seqMaxValue = seqMaxValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getSequenceDefineId() {
		return sequenceDefineId;
	}

	public void setSequenceDefineId(UUID sequenceDefineId) {
		this.sequenceDefineId = sequenceDefineId;
	}
	
}