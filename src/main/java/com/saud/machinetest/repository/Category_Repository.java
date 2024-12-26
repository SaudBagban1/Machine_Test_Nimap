package com.saud.machinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saud.machinetest.model.Category;
import java.util.List;

//Category Database Layer
@Repository
public interface Category_Repository extends JpaRepository<Category, Long>{

	
}
