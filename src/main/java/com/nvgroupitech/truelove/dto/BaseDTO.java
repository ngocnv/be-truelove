package com.nvgroupitech.truelove.dto;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nvgroupitech.truelove.json.databind.NullSerializer;


public abstract class BaseDTO {

	@JsonProperty(value = "errorMessage", defaultValue = Strings.EMPTY, required = true)
	@JsonSerialize(nullsUsing = NullSerializer.class)
	@JsonInclude(Include.NON_EMPTY)
	protected String errorMessage;

	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty(value = "errorCode", defaultValue = Strings.EMPTY, required = true)
	@JsonSerialize(nullsUsing = NullSerializer.class)
	protected String errorCode;

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String newErrorMessage) {
		this.errorMessage = newErrorMessage;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String newErrorCode) {
		this.errorCode = newErrorCode;
	}
}
