package com.deliveryapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deliveryapp.model.Brand;
import com.deliveryapp.model.BrandDto;
import com.deliveryapp.model.Cuisine;
import com.deliveryapp.model.CuisineDto;
import com.deliveryapp.model.Restaurant;
import com.deliveryapp.model.RestaurantDto;

@Component
public class DeliveryMapper {

	@Autowired
	private ModelMapper mapper;

	public RestaurantDto toRestaurantDto(Restaurant restaurant) {
		return mapper.map(restaurant, RestaurantDto.class);
	}

	public Restaurant toRestaurantEntity(RestaurantDto restaurantDto) {
		return mapper.map(restaurantDto, Restaurant.class);
	}
	
	//brand conversion
	public BrandDto toBrandDto(Brand brand) {
		return mapper.map(brand, BrandDto.class);
	}

	public Brand toBrandEntity(BrandDto brandDto) {
		return mapper.map(brandDto, Brand.class);
	}
	
	//cuisine conversion
	
	public CuisineDto toCuisineDto(Cuisine cuisine) {
		return mapper.map(cuisine, CuisineDto.class);
	}

	public Cuisine toCuisineEntity(CuisineDto cuisineDto) {
		return mapper.map(cuisineDto, Cuisine.class);
	}
	
	
	
	
	
	
	
}
