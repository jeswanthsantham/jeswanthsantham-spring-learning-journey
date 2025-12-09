package com.restaurantapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantDto {
	private String restaurantName;
	private Integer restaurantId;
	private String city;
	private String cuisine;
	private Category category; // veg,nonveg
	
	private Set<MenuItemDto> menuItems;
	
	

}
