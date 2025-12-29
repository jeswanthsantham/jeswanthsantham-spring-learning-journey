package com.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemType {

	STARTER("STARTER"),
	MAINCOURSE("MAIN COURSE"),
	DESSERT("DESSERT"),
	BF("BREAKFAST");
	
    private String type;
    
	
}
