package com.restaurantapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.RestaurantDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService{
	
	private final ModelMapper mapper;

	@Override
	public void addRestuarant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRestuarant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestuarant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestaurantDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemTypeCuisine(String itemType, String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCityAndCuisine(String city, String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemType(Category category, String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(Category category, String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNameContains(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
