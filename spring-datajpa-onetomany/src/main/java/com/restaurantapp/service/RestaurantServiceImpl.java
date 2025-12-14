package com.restaurantapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRepository;


@Service
public class RestaurantServiceImpl implements IRestaurantService{
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IRestaurantRepository restaurantRepository;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
       Restaurant restaurant = mapper.map(restaurantDto,Restaurant.class);
       restaurantRepository.save(restaurant);
       
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.map(restaurantDto,Restaurant.class);
	       restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		 restaurantRepository.deleteById(restaurantId);		
	}

	@Override
	public List<RestaurantDto> getAll() {
		return restaurantRepository.findAll()
		.stream()
		.map(restaurant->{
			RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
			Set<MenuItemDto> menuItems = restaurant.getMenuItems().stream()
			.map(menu->mapper.map(menu, MenuItemDto.class))
			.collect(Collectors.toSet());
			restaurantDto.setMenuItems(menuItems);
			return restaurantDto;
			})
		.toList();
		
	
		
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
		if (opt.isPresent()) {
			Restaurant restaurant = opt.get();
			RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
			Set<MenuItemDto> menuItems = restaurant.getMenuItems().stream()
			.map(menu->mapper.map(menu, MenuItemDto.class))
			.collect(Collectors.toSet());
			restaurantDto.setMenuItems(menuItems);
			return restaurantDto;
			}
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
		return restaurantRepository.findByCategory(category)
				.stream()
				.map(restaurant->{
					RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
					Set<MenuItemDto> menuItems = restaurant.getMenuItems().stream()
					.map(menu->mapper.map(menu, MenuItemDto.class))
					.collect(Collectors.toSet());
					restaurantDto.setMenuItems(menuItems);
					return restaurantDto;
					})
				.toList();
		
	}

	@Override
	public List<RestaurantDto> getByCategoryItemType(Category category, String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(Category category, String itemName) {
		return restaurantRepository.findByCategoryItemName(category, itemName)
				.stream()
				.map(restaurant->{
					RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
					Set<MenuItemDto> menuItems = restaurant.getMenuItems().stream()
					.map(menu->mapper.map(menu, MenuItemDto.class))
					.collect(Collectors.toSet());
					restaurantDto.setMenuItems(menuItems);
					return restaurantDto;
					})
				.toList();
	}

	@Override
	public List<RestaurantDto> getByItemNameContains(String itemName) {
		return restaurantRepository.findByItemNameContains("%"+itemName+"%")
				.stream()
				.map(restaurant->{
					RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
					Set<MenuItemDto> menuItems = restaurant.getMenuItems().stream()
					.map(menu->mapper.map(menu, MenuItemDto.class))
					.collect(Collectors.toSet());
					restaurantDto.setMenuItems(menuItems);
					return restaurantDto;
					})
				.toList();
	}

	@Override
	public List<RestaurantDto> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
