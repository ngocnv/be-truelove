package com.nvgroupitech.truelove.enums;

public enum ResultState {
	SUCCESSS('S'), ERROR('E');
	private char result;
	ResultState(char result){
		this.result=result;
	}
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}

}
