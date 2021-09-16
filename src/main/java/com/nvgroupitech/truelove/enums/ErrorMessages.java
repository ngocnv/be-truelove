package com.nvgroupitech.truelove.enums;

public enum ErrorMessages {

	E0001("E0001", "common.e.E0001"),
	E0002("E0002","common.e.E0002");

	private String errorCode;

	private String errorDefaultMsgCd;

	private ErrorMessages(String newErrorCode, String newErrorDefault) {
		this.errorCode = newErrorCode;
		this.errorDefaultMsgCd = newErrorDefault;
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

	public static ErrorMessages getErrorMessages(String code) {
		for (ErrorMessages error : ErrorMessages.values()) {
			if (error.getErrorCode().equals(code)) {
				return error;
			}
		}
		return null;
	}

}
