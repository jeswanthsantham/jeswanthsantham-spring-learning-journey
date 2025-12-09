package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemType {
	
	STARTER("STARTER"), 
	MAIN("MAIN_COURSE"),
	DESSERT("DESSERT"),
	BF("BREAKFAST");
	
	private String type;
	
	
}
