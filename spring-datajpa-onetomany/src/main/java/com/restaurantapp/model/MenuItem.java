package com.restaurantapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MenuItem {
	@Column(length = 30)
	private String itemName;
	@Id
	@GeneratedValue(generator = "item_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "item_gen",sequenceName = "item_seq", initialValue = 50)
	
	private Integer itemId;
	private double price;
	private String itemType; //starter,dessert

}
