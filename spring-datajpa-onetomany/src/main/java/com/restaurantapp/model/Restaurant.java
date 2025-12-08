package com.restaurantapp.model;

import java.util.Set;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
	private String restaurantName;
	private Integer restaurantId;
	private String city;
	private String cuisine;
	private String category; // veg,nonveg
	
	@OneToMany
	private Set<MenuItem> menuItems;
	
	
	

}
