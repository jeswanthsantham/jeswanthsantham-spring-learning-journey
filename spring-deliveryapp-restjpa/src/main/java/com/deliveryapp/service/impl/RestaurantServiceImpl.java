package com.deliveryapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.Restaurant;
import com.deliveryapp.model.RestaurantRequest;
import com.deliveryapp.model.RestaurantResponse;
import com.deliveryapp.repository.IRestaurantRepository;
import com.deliveryapp.service.IRestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService {
	
	private final DeliveryMapper mapper;
	private final IRestaurantRepository repository;

	@Override
	public void addRestaurant(RestaurantRequest restaurantRequest) {
		Restaurant restaurant = mapper.toRestaurantEntity(restaurantRequest);
		repository.save(restaurant);
		
	}

	@Override
	public void updateRestaurant(RestaurantRequest restaurantRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestaurantResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantResponse getById(int restaurantId) {
	   
		return null;
	}

	@Override
	public List<RestaurantResponse> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
