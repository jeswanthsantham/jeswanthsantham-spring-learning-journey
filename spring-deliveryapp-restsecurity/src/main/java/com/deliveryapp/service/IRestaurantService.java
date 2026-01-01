package com.deliveryapp.service;

import java.util.List;

import com.deliveryapp.model.RestaurantRequest;
import com.deliveryapp.model.RestaurantResponse;


public interface IRestaurantService {

	void addRestaurant(RestaurantRequest restaurantRequest);
	void updateRestaurant(RestaurantRequest restaurantRequest);
	void deleteRestaurant(int restaurantId);
	List<RestaurantResponse> getAll();
	RestaurantResponse getById(int restaurantId);
	
	List<RestaurantResponse> getByCity(String city);
}
