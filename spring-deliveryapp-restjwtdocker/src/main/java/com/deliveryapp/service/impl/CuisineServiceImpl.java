package com.deliveryapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.Cuisine;
import com.deliveryapp.model.CuisineRequest;
import com.deliveryapp.model.CuisineResponse;
import com.deliveryapp.repository.ICuisineRepository;
import com.deliveryapp.service.ICuisineService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CuisineServiceImpl implements ICuisineService{
	private final ICuisineRepository cuisineRepository;
	private final DeliveryMapper mapper;

	@Override
	public void addCuisine(CuisineRequest cuisineRequest) {
		cuisineRepository.save(mapper.toCuisineEntity(cuisineRequest));
	}

	@Override
	public void updateCuisine(CuisineRequest cuisineRequest) {
		cuisineRepository.save(mapper.toCuisineEntity(cuisineRequest));		
	}

	@Override
	public void deleteCuisine(int cuisineId) {
		cuisineRepository.deleteById(cuisineId);		
	}

	@Override
	@Transactional
	public List<CuisineResponse> getAll() {
		return cuisineRepository.findAll()
			.stream()
			.map(cuisine->mapper.toCuisineResponse(cuisine))
			.toList();
	}

	@Override
	@Transactional
	public CuisineResponse getById(int cuisineId) {
		Cuisine cuisine = cuisineRepository.findById(cuisineId)
			.orElseThrow(()->new RuntimeException("invalid id"));
		return mapper.toCuisineResponse(cuisine);
	}

	
}




