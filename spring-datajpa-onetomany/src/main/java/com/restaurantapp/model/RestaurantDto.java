package com.restaurantapp.model;

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
	private String category; // veg,nonveg
	
	

}
