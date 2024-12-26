package com.saud.machinetest.service;

import java.util.List;

import com.saud.machinetest.model.Category;
import com.saud.machinetest.model.Product;
import com.saud.machinetest.payload.Product_Dto;
//Product Layer
public interface Product_Service_Dao {

	Product_Dto Product_Save(Product product);

	List<Product_Dto> product_FetchAllDetails(Integer value, Integer pageSize);

	Product_Dto product_FetchById(Long product_id);

	Product_Dto product_UpdateDetails(Long id, Product product);

	String product_Delete(Long id);

}
