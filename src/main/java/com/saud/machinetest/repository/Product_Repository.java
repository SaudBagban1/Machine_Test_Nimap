package com.saud.machinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saud.machinetest.model.Product;

//Product Database Layer
@Repository
public interface Product_Repository extends JpaRepository<Product, Long>{

}
