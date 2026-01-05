package com.deliveryapp.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.Brand;
import com.deliveryapp.model.BrandRequest;
import com.deliveryapp.model.BrandResponse;
import com.deliveryapp.repository.IBrandRepository;
import com.deliveryapp.service.IBrandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl implements IBrandService{

	private final IBrandRepository brandRepository;
	private final DeliveryMapper mapper;
	@Override
	public void addBrand(BrandRequest brandRequest) {
		brandRepository.save(mapper.toBrandEntity(brandRequest));
	}

	@Override
	public void updateBrand(BrandRequest brandRequest) {
		brandRepository.save(mapper.toBrandEntity(brandRequest));		
	}

	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
		
	}

	@Override
	public List<BrandResponse> getAll() {
		List<Brand> brands =  brandRepository.findAll();
		System.out.println(brands);
		 return brands.stream()
			.map(brand->mapper.toBrandResponse(brand))
			.toList();
	}

	@Override
	public BrandResponse getById(int brandId) {
		Brand brand = brandRepository.findById(brandId)
		      		.orElseThrow(()->new RuntimeException("invalid Id"));
		return mapper.toBrandResponse(brand);
	}
	
}













