package com.deliveryapp.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
	@JsonIgnore
	private Set<Restaurant> restaurants;

	@Override
	public int hashCode() {
		return Objects.hash(cuisineId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuisine other = (Cuisine) obj;
		return Objects.equals(cuisineId, other.cuisineId);
	}
	
	

}





