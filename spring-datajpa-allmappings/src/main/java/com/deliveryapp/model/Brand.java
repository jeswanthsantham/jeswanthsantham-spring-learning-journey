package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = "restaurants")
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq",initialValue = 100)
	private Integer brandId;
	private String brandName; 
	
	@OneToMany(mappedBy="brand")
	private Set<Restaurant> restaurants;
}






