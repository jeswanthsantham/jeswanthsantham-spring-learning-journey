package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantDto {
	private String restaurantName;
	private Integer restaurantId;
	@Enumerated(EnumType.STRING)
	private Category category; //veg or nonveg
	private double ratings;
	private Address address;
	private Set<MenuItemDto> menuItems; 
    private Brand brand;
	private Set<CuisineDto> cuisines;
	private Set<String> serviceType; //dining,delivery,nightlife
	
	
}














