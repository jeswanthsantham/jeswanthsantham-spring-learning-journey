package com.deliveryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MenuItem {
	@Id
	@GeneratedValue(generator = "item_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "item_gen",sequenceName = "item_seq",initialValue = 50)
	private Integer itemId;
	private String itemName;
	private double price;
	private String menuType; //breakfast,lunch,dessert
	@Enumerated(EnumType.STRING)
	private Category itemType; // veg or nonveg
	

}
