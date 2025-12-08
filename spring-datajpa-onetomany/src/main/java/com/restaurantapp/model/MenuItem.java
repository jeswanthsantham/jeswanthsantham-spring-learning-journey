package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuItem {
	
	private String itemName;
	private Integer itemId;
	private double price;
	private String itemType;

}
