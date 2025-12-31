package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantRequest {
	
	@NotBlank(message ="name should not be blank" )
	@NotNull
	private String restaurantName;
	
	private Integer restaurantId;
	@Enumerated(EnumType.STRING)
	private Category category; //veg or nonveg
	@Min(value = 1)
	@Max(value = 5, message = "value should be less than or equals to 5")
	private double ratings;
	private AddressRequest address;
	private Set<MenuItemRequest> menuItems; 
    private Brand brand;
	private Set<CuisineRequest> cuisines;
	private Set<String> serviceType; //dining,delivery,nightlife
	
	
}














