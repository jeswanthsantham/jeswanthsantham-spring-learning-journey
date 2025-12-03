package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{
	
	
	//derived queries
	// findBy, queryBy, getBy, readBy
	
	List<Product> findBybrand(String brand);
	List<Product> findByCategoryAndProductNameContains(String category, String productName);
	List<Product> findByPriceLessThan(double price);
	

}
