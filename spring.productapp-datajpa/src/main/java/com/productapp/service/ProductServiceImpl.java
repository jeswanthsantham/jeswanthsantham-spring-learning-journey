package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int productId) throws ProductNotfoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotfoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotfoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getBycategoryandNameContains(String category, String name) throws ProductNotfoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
