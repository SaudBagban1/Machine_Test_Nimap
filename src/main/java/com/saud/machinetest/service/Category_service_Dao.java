package com.saud.machinetest.service;

import java.util.List;

import com.saud.machinetest.model.Category;
//Category Dao Layer
public interface Category_service_Dao {

	Category category_Save(Category category);

	 List<Category> category_FetchAllDetails(Integer value,Integer pageSize);

	Category category_FetchById(Long categoryId);

	Category category_UpdateDetails(Long id, Category category);

	String category_Delete(Long id);

}
