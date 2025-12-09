package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemDto {
	
	private String itemName;
	private Integer itemId;
	private double price;
	private String itemType;

}
