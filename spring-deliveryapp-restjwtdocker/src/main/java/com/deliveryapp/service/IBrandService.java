package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.BrandRequest;
import com.deliveryapp.model.BrandResponse;


public interface IBrandService {

	void addBrand(BrandRequest brandRequest);
	void updateBrand(BrandRequest brandRequest);
	void deleteBrand(int brandId);
	List<BrandResponse> getAll();
	BrandResponse getById(int brandId);
	
	
}
