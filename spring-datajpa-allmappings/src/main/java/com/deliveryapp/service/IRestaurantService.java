package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.RestaurantDto;


public interface IRestaurantService {

	void addRestaurant(RestaurantDto restaurantDto);
	void updateRestaurant(RestaurantDto restaurantDto);
	void deleteRestaurant(int restaurantId);
	List<RestaurantDto> getAll();
	RestaurantDto getById(int restaurantId);
	
	List<RestaurantDto> getByCity(String city);
}
