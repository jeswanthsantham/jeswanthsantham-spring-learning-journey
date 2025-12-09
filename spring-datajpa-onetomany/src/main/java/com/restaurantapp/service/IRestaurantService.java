package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.RestaurantDto;

public interface IRestaurantService {
	
	void addRestuarant(RestaurantDto restaurantDto);
	void updateRestuarant(RestaurantDto restaurantDto);
	void deleteRestuarant(RestaurantDto restaurantDto);
	List<RestaurantDto> getAll();
	RestaurantDto getById(int restaurantId);
	
	List<RestaurantDto> getByCity(String city);
	List<RestaurantDto> getByItemTypeCuisine(String itemType,String cuisine);  //chinese starters
	List<RestaurantDto> getByCityAndCuisine(String city,String cuisine);//chennai, chinese
	List<RestaurantDto> getByCategory(Category category); //veg
	List<RestaurantDto> getByCategoryItemType(Category category,String itemType); //veg starters
	List<RestaurantDto> getByCategoryItemName(Category category,String itemName);//veg, paneer
	List<RestaurantDto> getByItemNameContains(String itemName);// paneer
	List<RestaurantDto> getByItemNameLessPrice(String itemName,double price);
	
	
	

}
