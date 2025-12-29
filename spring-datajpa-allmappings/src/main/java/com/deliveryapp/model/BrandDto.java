package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "restaurants")
public class BrandDto {
	
	private Integer brandId;
	private String brandName; 
	private Set<RestaurantDto> restaurants;
}






