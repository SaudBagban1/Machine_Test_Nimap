package com.saud.machinetest.payload;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.saud.machinetest.model.Category;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;


public class Product_Dto {

	private long product_id;
	private String product_Name;
	private String product_Description;
	private Category category;
	public long getProduct_id() {
		return product_id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public String getProduct_Description() {
		return product_Description;
	}
	public Category getCategory() {
		return category;
	}
	public Product_Dto(long product_id, String product_Name, String product_Description, Category category) {
		super();
		this.product_id = product_id;
		this.product_Name = product_Name;
		this.product_Description = product_Description;
		this.category = category;
	}
	public Product_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product_Dto [product_id=" + product_id + ", product_Name=" + product_Name + ", product_Description="
				+ product_Description + ", category=" + category + "]";
	}

	
	
}
