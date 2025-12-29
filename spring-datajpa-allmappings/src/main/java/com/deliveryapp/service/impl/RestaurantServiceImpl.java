package com.deliveryapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.Restaurant;
import com.deliveryapp.model.RestaurantDto;
import com.deliveryapp.repository.IRestaurantRepository;
import com.deliveryapp.service.IRestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService {
	
	private final DeliveryMapper mapper;
	private final IRestaurantRepository repository;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.toRestaurantEntity(restaurantDto);
		repository.save(restaurant);
		
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestaurantDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
	   
		return null;
	}

	@Override
	public List<RestaurantDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
