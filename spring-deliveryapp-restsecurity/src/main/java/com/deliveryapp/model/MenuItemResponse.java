package com.deliveryapp.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MenuItemResponse {
	private Integer itemId;
	private String itemName;
	private double price;
	private String menuType; //breakfast,lunch,dessert
	@Enumerated(EnumType.STRING)
	private Category itemType; // veg or nonveg
	

}
