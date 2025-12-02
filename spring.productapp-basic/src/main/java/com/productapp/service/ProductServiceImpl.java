package com.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;
import com.productapp.util.ProductDetails;

@Service
public class ProductServiceImpl implements IProductService {

	private ProductDetails productDetails;

	public ProductServiceImpl(ProductDetails productDetails) {
		super();
		this.productDetails = productDetails;
	}

	@Override
	public List<Product> getAll() {
		return productDetails.showProducts();
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

	@Override
	public Product getById(int productId) throws ProductNotfoundException {
		// TODO Auto-generated method stub
		// use optional and orelsethrow
		return null;
	}

}
