package com.saud.machinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saud.machinetest.model.Category;
import com.saud.machinetest.service.Category_Service_Impl;
import com.saud.machinetest.service.Category_service_Dao;

@RestController
@RequestMapping("/api/categories")
public class Category_Controller {

	@Autowired
	private Category_service_Dao category_service_Dao;

	@PostMapping
	public ResponseEntity<Category> category_Save(@RequestBody Category category) {
		Category category_Save = this.category_service_Dao.category_Save(category);
		return new ResponseEntity<>(category_Save, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Category>> category_FetchAllDetails(
			@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@RequestParam(value = "pagesize", defaultValue = "5", required = false) Integer pagesize) {
		List<Category> category_FetchAllDetails = this.category_service_Dao.category_FetchAllDetails(page, pagesize);
		return new ResponseEntity<List<Category>>(category_FetchAllDetails, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> category_FetchById(@PathVariable("id")Long id)
	{
		Category category_FetchById = this.category_service_Dao.category_FetchById(id);
		return new ResponseEntity<Category>(category_FetchById,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> category_DeleteDetail(@PathVariable("id") Long id)
	{
		return new ResponseEntity<String>(this.category_service_Dao.category_Delete(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> category_UpdateDetail(@PathVariable("id") Long id,@RequestBody Category category)
	{
		Category category_UpdateDetails = this.category_service_Dao.category_UpdateDetails(id, category);
		return new ResponseEntity(category_UpdateDetails,HttpStatus.OK);
	}
	
	
	

}
