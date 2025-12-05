package com.employeeapp.model;

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
public class Address {
	
	@Id
	@GeneratedValue(generator = "add_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "add_gen",sequenceName = "address_seq",initialValue = 10,allocationSize = 1)
	private Integer addressId;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;

}
