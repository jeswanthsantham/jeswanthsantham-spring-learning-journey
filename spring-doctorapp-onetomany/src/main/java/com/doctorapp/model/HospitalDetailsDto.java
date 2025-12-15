package com.doctorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
//should have properties that are pointing to the column in the database
//should have the same instance variable like the domain model
//should have ONLY parameterized constr for these instance variables
//should have ONLY getter methods for these instance variables
//should have a toString method
public class HospitalDetailsDto {

	String hospitalName;
	String city;
	String hospitalType;
}
