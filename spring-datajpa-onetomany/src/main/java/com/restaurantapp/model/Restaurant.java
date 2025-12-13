package com.restaurantapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Restaurant {
	@Column(length = 30)
	private String restaurantName;
	@Id
	@GeneratedValue(generator = "restuarant_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restuarant_gen",sequenceName = "restuarant_seq", initialValue = 1)
	private Integer restaurantId;
	@Column(length = 30)
	private String city;
	private String cuisine;
	@Enumerated(EnumType.STRING)
	private Category category; // veg,nonveg
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_id")
	private Set<MenuItem> menuItems;
	
	
	

}
