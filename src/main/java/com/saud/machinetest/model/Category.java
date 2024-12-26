package com.saud.machinetest.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Category Entity Class
@Entity
@Table(name = "category_detail")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	private String category_Name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	@JsonManagedReference 
	private Set<Product> products;

	public long getCategory_id() {
		return category_id;
	}
 
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_Name=" + category_Name + "]";
	}

}
