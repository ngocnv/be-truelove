package com.nvgroupitech.truelove.criteria;

import com.nvgroupitech.truelove.dto.filter.StringFilter;

public class UserCriteria {
    private StringFilter name;

	public StringFilter getName() {
		if(name == null) {
			name = new StringFilter();
		}
		return name;
	}

	public void setName(StringFilter name) {
		this.name = name;
	}
    
}
