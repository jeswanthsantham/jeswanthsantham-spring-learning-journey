package com.deliveryapp.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "restaurants")
public class CuisineResponse {
	private Integer cuisineId;
	@Enumerated(EnumType.STRING)
	private Cuisines cuisineName; //northindian,italian
	@JsonIgnore
	private Set<RestaurantResponse> restaurants;
	
	

}





