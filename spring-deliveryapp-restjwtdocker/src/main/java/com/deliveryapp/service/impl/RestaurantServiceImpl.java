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
		Restaurant restaurant = mapper.toRestaurantEntity(restaurantRequest);
		repository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		repository.deleteById(restaurantId);
	}

	@Override
	@Transactional
	public List<RestaurantResponse> getAll() {
		return repository.findAll()
				.stream()
				.map(restaurant->mapper.toRestaurantResponse(restaurant))
				.toList();
	}

	@Override
	@Transactional
	public RestaurantResponse getById(int restaurantId) {
		Restaurant restaurant = repository.findById(restaurantId)
			.orElseThrow(()-> new RestaurantNotFoundException("invalid id"));
		return mapper.toRestaurantResponse(restaurant);
	}

	@Override
	public List<RestaurantResponse> getByCity(String city) {
		List<Restaurant> restaurants = repository.findByCity(city);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("restaurant for this city not found");
		return restaurants	
			.stream()
			.map(restaurant->mapper.toRestaurantResponse(restaurant))
			.toList();
	}

}
