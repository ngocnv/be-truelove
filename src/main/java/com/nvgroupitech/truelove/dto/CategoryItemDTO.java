package com.nvgroupitech.truelove.dto;

import java.util.UUID;

import com.nvgroupitech.truelove.enums.Category;
import com.nvgroupitech.truelove.enums.LanguageCode;

public class CategoryItemDTO {
	private UUID itemId;
	
	private Category category;
	
	private String description;
	
	private String name;
	
	private LanguageCode language;
	
	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LanguageCode getLanguage() {
		return language;
	}

	public void setLanguage(LanguageCode language) {
		this.language = language;
	}
	
}
