package com.nvgroupitech.truelove.enums;

public enum ResultState {
	S("Success"), E("Error");
	private String result;
	ResultState(String result){
		this.result=result;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
