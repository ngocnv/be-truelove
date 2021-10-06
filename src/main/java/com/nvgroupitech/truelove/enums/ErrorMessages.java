package com.nvgroupitech.truelove.enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessages {

	E0001("E0001","common.e.E0001",HttpStatus.INTERNAL_SERVER_ERROR),
	E0002("E0002","common.e.E0002",HttpStatus.CONFLICT),
	E0003("E0003","common.e.E0003",HttpStatus.UNAUTHORIZED),
	E0004("E0004","common.e.E0004",HttpStatus.BAD_REQUEST);

	private String errorCode;

	private String errorDefaultMsgCd;
	
	private HttpStatus httpStatusCode;

	private ErrorMessages(String newErrorCode, String newErrorDefault,HttpStatus httpStatusCode) {
		this.errorCode = newErrorCode;
		this.errorDefaultMsgCd = newErrorDefault;
		this.httpStatusCode=httpStatusCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String newErrorCode) {
		this.errorCode = newErrorCode;
	}

	
	public String getErrorDefaultMsgCd() {
		return this.errorDefaultMsgCd;
	}

	
	public void setErrorDefaultMsgCd(String newErrorDefault) {
		this.errorDefaultMsgCd = newErrorDefault;
	}
	
	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public static ErrorMessages getErrorMessages(String code) {
		for (ErrorMessages error : ErrorMessages.values()) {
			if (error.getErrorCode().equals(code)) {
				return error;
			}
		}
		return null;
	}

}
