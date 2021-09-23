package com.nvgroupitech.truelove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nvgroupitech.truelove.enums.ResultState;

public abstract class BaseDTO {

	@JsonProperty(value = "errorMessage")
	protected String errorMessage;
	
	@JsonProperty(value = "errorCode")
	protected String errorCode;

	protected ResultState result;

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

	public ResultState getResult() {
		return result;
	}

	public void setResult(ResultState result) {
		this.result = result;
	}
	
}
