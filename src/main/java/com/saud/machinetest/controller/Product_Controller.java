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
import com.saud.machinetest.model.Product;
import com.saud.machinetest.payload.Product_Dto;
import com.saud.machinetest.service.Category_Service_Impl;
import com.saud.machinetest.service.Category_service_Dao;
import com.saud.machinetest.service.Product_Service_Dao;

//Request and Response Handler
@RestController
@RequestMapping("/api/products")
public class Product_Controller {

	@Autowired
	private Product_Service_Dao product_Service_Dao;

	@PostMapping
	public ResponseEntity<Product_Dto> product_Save(@RequestBody Product product) {
		Product_Dto product_Save = this.product_Service_Dao.Product_Save(product);
		System.out.println("kjnkjabcjaebcjhaebjhbvjhvbvjh"+product);
		return new ResponseEntity<>(product_Save, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product_Dto>> product_FetchAllDetails(
			@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@RequestParam(value = "pagesize", defaultValue = "5", required = false) Integer pagesize) {
	 List<Product_Dto> product_FetchAllDetails = this.product_Service_Dao.product_FetchAllDetails(page, pagesize);
		return new ResponseEntity(product_FetchAllDetails, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product_Dto> product_FetchById(@PathVariable("id") Long id) {
	 Product_Dto product_FetchById = this.product_Service_Dao.product_FetchById(id);
		return new ResponseEntity(product_FetchById, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> product_DeleteDetail(@PathVariable("id") Long id) {
		return new ResponseEntity<String>(this.product_Service_Dao.product_Delete(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product_Dto> product_UpdateDetail(@PathVariable("id") Long id, @RequestBody Product product) {
		Product_Dto product_UpdateDetails = this.product_Service_Dao.product_UpdateDetails(id, product);
		return new ResponseEntity(product_UpdateDetails, HttpStatus.OK);
	}

}
