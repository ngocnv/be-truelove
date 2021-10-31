package com.nvgroupitech.truelove.models.jpa.entities;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.nvgroupitech.truelove.enums.Category;
import com.nvgroupitech.truelove.enums.LanguageCode;

@Table(name = "app_category_items")
@Entity
public class CategoryItemEntity extends CommonAudit {

	private static final long serialVersionUID = 4897332874817490549L;

	@Id
	@Column(name = "item_id")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID itemId;
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="language")
	@Enumerated(EnumType.STRING)
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
