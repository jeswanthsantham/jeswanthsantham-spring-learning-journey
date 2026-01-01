package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.CuisineRequest;
import com.deliveryapp.model.CuisineResponse;


public interface ICuisineService {

	void addCuisine(CuisineRequest cuisineRequest);
	void updateCuisine(CuisineRequest cuisineRequest);
	void deleteCuisine(int cuisineId);
	List<CuisineResponse> getAll();
	CuisineResponse getById(int cuisineId);
	
}
