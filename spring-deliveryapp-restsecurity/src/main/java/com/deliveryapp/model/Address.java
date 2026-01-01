package com.deliveryapp.model;

import jakarta.persistence.Entity;
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
public class Address {
	
	@Id
	@GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_gen",sequenceName = "address_seq",initialValue = 50)
	private Integer addressId;
	private String location;
	private String city;
	private String state;

}
