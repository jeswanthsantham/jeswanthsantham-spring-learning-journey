package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;

public interface IProductService {
	
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(long productId);
	List<ProductDto> getAll();
	ProductDto getById(long productId)throws ProductNotfoundException;
	
	// querying
	
	List<ProductDto> getByBrand(String brand) throws ProductNotfoundException;
	List<ProductDto> getByLesserPrice(double price)throws ProductNotfoundException;
	List<ProductDto> getBycategoryandNameContains(String category, String name)throws ProductNotfoundException;
	
	

}
