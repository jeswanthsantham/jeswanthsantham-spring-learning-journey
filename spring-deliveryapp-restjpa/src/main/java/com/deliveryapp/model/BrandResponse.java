package com.deliveryapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "restaurants")
public class BrandResponse {
	
	private Integer brandId;
	private String brandName; 
	private Set<RestaurantRequest> restaurants;
}






