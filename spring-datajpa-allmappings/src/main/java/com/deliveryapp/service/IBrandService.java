package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.BrandDto;


public interface IBrandService {

	void addBrand(BrandDto brandDto);
	void updateBrand(BrandDto brandDto);
	void deleteBrand(int brandId);
	List<BrandDto> getAll();
	BrandDto getById(int brandId);
	
	
}
