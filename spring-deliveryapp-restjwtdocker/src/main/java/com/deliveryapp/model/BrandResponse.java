package com.deliveryapp.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "restaurants")
public class BrandResponse {
	
	private Integer brandId;
	private String brandName; 
//	@JsonIgnore
//	private Set<RestaurantResponse> restaurants;
}






