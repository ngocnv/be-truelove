package com.nvgroupitech.truelove.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nvgroupitech.truelove.constant.CommonConstant;
import com.nvgroupitech.truelove.utils.ApiUtil;



public enum MessageLanguage {
	
	LANG_VN("vn", "vietnam"),
	
	LANG_EN("en", "english");

	private String id;

	private String name;

	private MessageLanguage(String initId, String initName) {
		this.id = initId;
		this.setName(initName);
	}

	
	@JsonCreator
	protected static MessageLanguage deserialize(String id) {
		for (MessageLanguage language : MessageLanguage.values()) {
			if (language.getId().equals(id)) {
				ApiUtil.putLocalContext(CommonConstant.LANGUAGE_CODE, id);
				return language;
			}
		}
		ApiUtil.putLocalContext(CommonConstant.LANGUAGE_CODE, "");
		return null;
	}

	
	public static MessageLanguage getMessageLanguage(String id) {
		for (MessageLanguage language : MessageLanguage.values()) {
			if (language.getId().equals(id)) {
				return language;
			}
		}
		return null;
	}

	public void setId(String newId) {
		this.id = newId;
	}
	
	@JsonValue
	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
}
