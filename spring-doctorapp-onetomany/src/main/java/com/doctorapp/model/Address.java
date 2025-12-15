package com.doctorapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "doc_address")
public class Address {
	@Id
	@GeneratedValue(generator = "doc_address_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "doc_address_gen",sequenceName = "doc_address_seq",initialValue = 10,allocationSize = 1)
	private Integer addressId;
	@Column(length=30)
	private String location;
	@Column(length=30)
	private String city;
	@Column(length=30)
	private String state;

}
