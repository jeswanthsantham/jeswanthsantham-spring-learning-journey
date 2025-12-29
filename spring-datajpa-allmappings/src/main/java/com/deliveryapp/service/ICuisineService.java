package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.CuisineDto;


public interface ICuisineService {

	void addCuisine(CuisineDto cuisineDto);
	void updateCuisine(CuisineDto cuisineDto);
	void deleteCuisine(int cuisineId);
	List<CuisineDto> getAll();
	CuisineDto getById(int cuisineId);
	
}
