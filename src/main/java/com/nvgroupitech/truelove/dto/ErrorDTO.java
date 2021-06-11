package com.nvgroupitech.truelove.dto;

public class ErrorDTO {
	
	private String message ;
	
	private String errorCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String errorCode () {
		return this.errorCode;
	}
}
