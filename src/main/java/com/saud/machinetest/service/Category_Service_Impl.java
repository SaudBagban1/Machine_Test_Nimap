package com.saud.machinetest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saud.machinetest.custom_exception.Custom_Exception;
import com.saud.machinetest.model.Category;
import com.saud.machinetest.repository.Category_Repository;
//Category Service Layer (Bussiness logic)
@Service
public class Category_Service_Impl implements Category_service_Dao {
	@Autowired
	private Category_Repository category_Repository;

	public Category category_Save(Category category) {
		return this.category_Repository.save(category);
	}

	public List<Category> category_FetchAllDetails(Integer value, Integer pageSize) {
		Pageable pageable = PageRequest.of(value, pageSize);
		Page<Category> all = this.category_Repository.findAll(pageable);
		List<Category> content = all.getContent();
		return content;

	}

	public Category category_FetchById(Long categoryId) {

		Category category = this.category_Repository.findById(categoryId)
				.orElseThrow(() -> new Custom_Exception("ID " + categoryId + " NOT FOUND"));
		return category;

	}

	public Category category_UpdateDetails(Long id, Category category) {

		Category byCategory_id = this.category_Repository.findById(id)
				.orElseThrow(() -> new Custom_Exception("ID " + id + " NOT FOUND"));
		if (byCategory_id != null) {

			if (category.getCategory_Name() != null) {
				byCategory_id.setCategory_Name(category.getCategory_Name());
			}

		}

		return this.category_Repository.save(byCategory_id);
	}

	public String category_Delete(Long id) {
		Category category_FetchById = this.category_Repository.findById(id)
				.orElseThrow(() -> new Custom_Exception("ID " + id + " NOT FOUND"));
		this.category_Repository.deleteById(id);
		return "ID " + id + " DELETE SUCCESSFULL";
	}

}
