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
@Table(name="sequence_make")
public class SequenceMakeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "sequence_make_id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID sequenceMakeId;
	
	@Column(name="seq_code")
	private String seqCode;


	@Column(name="sort_order")
	private Long sortOrder;

	@Column(name="begin_index")
	private Long beginIndex;
	
	@Column(name="recognition")
	private String recognition;

	@Column(name="data_create_time")
	private String dataCreateTime;

	@Column(name="data_create_user")
	private String dataCreateUser;

	@Column(name="data_update_time")
	private String dataUpdateTime;

	@Column(name="data_update_user")
	private String dataUpdateUser;

	@Column(name="fill_mode")
	private String fillMode;

	@Column(name="fill_value")
	private String fillValue;

	@Column(name="seq_category")
	private String seqCategory;

	@Column(name="trim_length")
	private Long trimLength;

	public UUID getSequenceMakeId() {
		return sequenceMakeId;
	}

	public void setSequenceMakeId(UUID sequenceMakeId) {
		this.sequenceMakeId = sequenceMakeId;
	}

	public String getSeqCode() {
		return seqCode;
	}

	public void setSeqCode(String seqCode) {
		this.seqCode = seqCode;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Long beginIndex) {
		this.beginIndex = beginIndex;
	}

	public String getDataCreateTime() {
		return dataCreateTime;
	}

	public void setDataCreateTime(String dataCreateTime) {
		this.dataCreateTime = dataCreateTime;
	}

	public String getDataCreateUser() {
		return dataCreateUser;
	}

	public void setDataCreateUser(String dataCreateUser) {
		this.dataCreateUser = dataCreateUser;
	}

	public String getDataUpdateTime() {
		return dataUpdateTime;
	}

	public void setDataUpdateTime(String dataUpdateTime) {
		this.dataUpdateTime = dataUpdateTime;
	}

	public String getDataUpdateUser() {
		return dataUpdateUser;
	}

	public void setDataUpdateUser(String dataUpdateUser) {
		this.dataUpdateUser = dataUpdateUser;
	}

	public String getFillMode() {
		return fillMode;
	}

	public void setFillMode(String fillMode) {
		this.fillMode = fillMode;
	}

	public String getFillValue() {
		return fillValue;
	}

	public void setFillValue(String fillValue) {
		this.fillValue = fillValue;
	}

	public String getSeqCategory() {
		return seqCategory;
	}

	public void setSeqCategory(String seqCategory) {
		this.seqCategory = seqCategory;
	}

	public Long getTrimLength() {
		return trimLength;
	}

	public void setTrimLength(Long trimLength) {
		this.trimLength = trimLength;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
}