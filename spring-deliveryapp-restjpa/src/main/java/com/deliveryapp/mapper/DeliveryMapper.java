package com.deliveryapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deliveryapp.model.Brand;
import com.deliveryapp.model.BrandRequest;
import com.deliveryapp.model.BrandResponse;
import com.deliveryapp.model.Cuisine;
import com.deliveryapp.model.CuisineRequest;
import com.deliveryapp.model.CuisineResponse;
import com.deliveryapp.model.Restaurant;
import com.deliveryapp.model.RestaurantRequest;
import com.deliveryapp.model.RestaurantResponse;

@Component
public class DeliveryMapper {

	@Autowired
	private ModelMapper mapper;

	// controller to entity (request->entity)
	
	public Restaurant toRestaurantEntity(RestaurantRequest restaurantRequest) {
		return mapper.map(restaurantRequest, Restaurant.class);
	}

	public Brand toBrandEntity(BrandRequest brandRequest) {
		return mapper.map(brandRequest, Brand.class);
	}

	public Cuisine toCuisineEntity(CuisineRequest cuisineRequest) {
		return mapper.map(cuisineRequest, Cuisine.class);
	}
	

	// service back to controller (entity->response)
	public RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
		return mapper.map(restaurant, RestaurantResponse.class);
	}

	public BrandResponse toBrandResponse(Brand brand) {
		return mapper.map(brand, BrandResponse.class);
	}

	public CuisineResponse toCuisineResponse(Cuisine cuisine) {
		return mapper.map(cuisine, CuisineResponse.class);
	}

}
