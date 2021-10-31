package com.nvgroupitech.truelove.criteria;

import com.nvgroupitech.truelove.dto.filter.StringFilter;

public class CategoryItemCriteria {

	private StringFilter category;
	
	private StringFilter name;

	public StringFilter getCategory() {
		if(category == null) {
			category = new StringFilter();
		}
		return category;
	}

	public void setCategory(StringFilter category) {
		this.category = category;
	}

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
