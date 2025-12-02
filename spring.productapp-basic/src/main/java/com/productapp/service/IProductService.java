package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;

public interface IProductService {
	List<Product> getAll();
	List<Product> getByBrand(String brand) throws ProductNotfoundException;
	List<Product> getByLesserPrice(double price)throws ProductNotfoundException;
	List<Product> getBycategoryandNameContains(String category, String name)throws ProductNotfoundException;
	Product getById(int productId)throws ProductNotfoundException;
	

}
