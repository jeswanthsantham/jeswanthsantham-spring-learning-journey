package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "restaurants")
public class CuisineResponse {
	private Integer cuisineId;
	@Enumerated(EnumType.STRING)
	private Cuisines cuisineName; //northindian,italian
	private Set<RestaurantRequest> restaurants;
	
	

}





