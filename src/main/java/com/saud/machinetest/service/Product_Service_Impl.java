package com.saud.machinetest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saud.machinetest.custom_exception.Custom_Exception;
import com.saud.machinetest.model.Category;
import com.saud.machinetest.model.Product;
import com.saud.machinetest.payload.Product_Dto;
import com.saud.machinetest.repository.Category_Repository;
import com.saud.machinetest.repository.Product_Repository;

import jakarta.transaction.Transactional;

@Service
public class Product_Service_Impl implements Product_Service_Dao {

	@Autowired
	private Product_Repository product_Repository;

	@Autowired
	private Category_service_Dao category_service_Dao;
	
	@Transactional
	public Product_Dto Product_Save(Product product) {
		
		Category category = this.category_service_Dao.category_FetchById(product.getCategory().getCategory_id());
		product.setCategory(category);
		
		Product save = this.product_Repository.save(product);
		return new Product_Dto(save.getProduct_id(), save.getProduct_Name(), save.getProduct_Description(), save.getCategory());
	}

	public List<Product_Dto> product_FetchAllDetails(Integer value, Integer pageSize) {
		Pageable pageable = PageRequest.of(value, pageSize);
		Page<Product> all = this.product_Repository.findAll(pageable);
		List<Product> content = all.getContent();
		List<Product_Dto> list=new ArrayList<Product_Dto>();
		for(Product product:content)
		{
			Product_Dto product_Dto = new Product_Dto(product.getProduct_id(), product.getProduct_Name(), product.getProduct_Description(), product.getCategory());
			list.add(product_Dto);
		}
		return list;

	}

	public Product_Dto product_FetchById(Long product_id) {

		Product product = this.product_Repository.findById(product_id).orElseThrow(()->new Custom_Exception("ID "+product_id+" NOT FOUND"));
		return new Product_Dto(product.getProduct_id(), product.getProduct_Name(), product.getProduct_Description(), product.getCategory());

	}

	public Product_Dto product_UpdateDetails(Long id, Product product) {

		Product product2 = this.product_Repository.findById(id).orElseThrow(()->new Custom_Exception("ID "+id+" NOT FOUND"));
		if (product2 != null) {

			if (product.getProduct_Name() != null) {
				product2.setProduct_Name(product.getProduct_Name());
			}
			if (product.getProduct_Description() != null) {
				product2.setProduct_Description(product.getProduct_Description());
			}

		}
		Product save = this.product_Repository.save(product2);
		return new Product_Dto(save.getProduct_id(), save.getProduct_Name(),save.getProduct_Description(), save.getCategory());
	}

	public String product_Delete(Long id) {
		Product product = this.product_Repository.findById(id).orElseThrow(()->new Custom_Exception("ID "+id+" NOT FOUND"));
		this.product_Repository.deleteById(id);
		return "ID " + id + " DELETE SUCCESSFULL";
	}

}
