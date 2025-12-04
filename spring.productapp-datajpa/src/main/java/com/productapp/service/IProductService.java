package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.ProductDto;

public interface IProductService {
	
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(long productId);
	List<ProductDto> getAll();
	ProductDto getById(long productId)throws ProductNotfoundException;
	
	// querying
	//derived queries
	List<ProductDto> getByBrand(String brand) throws ProductNotfoundException;
	List<ProductDto> getByLesserPrice(double price)throws ProductNotfoundException;
	List<ProductDto> getBycategoryandNameContains(String category, String name)throws ProductNotfoundException;
	
	//custom queries
	List<ProductDto> getByCategory(String category) throws ProductNotfoundException;
	List<ProductDto> getByBrandAndLessPrice(String brand, double price) throws ProductNotfoundException;
	
	List<ProductDto> getByNameContains(String name)throws ProductNotfoundException;
	//native query
	List<ProductDto> getByGreaterPrice(double price)throws ProductNotfoundException;
	//namedQuery
	List<ProductDto> getByBrandAndCategory(String brand, String category)throws ProductNotfoundException;
	
	//using @Modifying annotation
	void updateProduct(long productId, double price);
	
	//sorting
	List<ProductDto> getSortedProducts(String choice);
	
	//pagination
	List<ProductDto> getPagedProducts(int pageNo,int pageSize);
	
	
	
	

}
