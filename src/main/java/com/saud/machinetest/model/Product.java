package com.saud.machinetest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//Product Entity
@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String product_Name;
	private String product_Description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Category category;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_Name=" + product_Name + ", product_Description="
				+ product_Description + ", category=" + category + "]";
	}

}
