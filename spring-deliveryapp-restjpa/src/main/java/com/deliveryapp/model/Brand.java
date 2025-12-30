package com.deliveryapp.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq",initialValue = 100)
	private Integer brandId;
	private String brandName; 
	
	@OneToMany(mappedBy="brand")
	@JsonIgnore
	private Set<Restaurant> restaurants;

	
	//
	@Override
	public int hashCode() {
		return Objects.hash(brandId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(brandId, other.brandId);
	}
	
}






