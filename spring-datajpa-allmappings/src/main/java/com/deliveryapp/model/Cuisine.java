package com.deliveryapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Cuisine {
	@Id
	@GeneratedValue(generator = "cuisine_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cuisine_gen",sequenceName = "cuisine_seq",initialValue = 20)
	private Integer cuisineId;
	
	@Enumerated(EnumType.STRING)
	private Cuisines cuisineName; //northindian,italian
	
	@ManyToMany(mappedBy = "cuisines")
	private Set<Restaurant> restaurants;
	
	

}





