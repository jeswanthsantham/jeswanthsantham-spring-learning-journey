package com.deliveryapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliveryapp.exception.RestaurantNotFoundException;
import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.Restaurant;
import com.deliveryapp.model.RestaurantRequest;
import com.deliveryapp.model.RestaurantResponse;
import com.deliveryapp.repository.IRestaurantRepository;
import com.deliveryapp.service.IRestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements IRestaurantService {
	
	private final DeliveryMapper mapper;
	private final IRestaurantRepository restaurantRepository;

	@Override
	public void addRestaurant(RestaurantRequest restaurantRequest) {
		restaurantRepository.save(mapper.toRestaurantEntity(restaurantRequest));
		
	}

	@Override
	public void updateRestaurant(RestaurantRequest restaurantRequest) {
		restaurantRepository.save(mapper.toRestaurantEntity(restaurantRequest));		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);		
	}

	@Override
	public List<RestaurantResponse> getAll() {
		return restaurantRepository.findAll().stream()
				.map(restaurant->mapper.toRestaurantResponse(restaurant))
				.toList();
	}

	@Override
	public RestaurantResponse getById(int restaurantId) {
	    Restaurant restaurant = restaurantRepository.findById(restaurantId)
	    		.orElseThrow(()-> new RestaurantNotFoundException("Invalid Id"));
		return mapper.toRestaurantResponse(restaurant);
	}

	@Override
	public List<RestaurantResponse> getByCity(String city) {
		return null;
	}

}
