package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;

public interface IProductService {
	
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	List<Product> getAll();
	Product getById(int productId)throws ProductNotfoundException;
	
	// querying
	
	List<Product> getByBrand(String brand) throws ProductNotfoundException;
	List<Product> getByLesserPrice(double price)throws ProductNotfoundException;
	List<Product> getBycategoryandNameContains(String category, String name)throws ProductNotfoundException;
	
	

}
