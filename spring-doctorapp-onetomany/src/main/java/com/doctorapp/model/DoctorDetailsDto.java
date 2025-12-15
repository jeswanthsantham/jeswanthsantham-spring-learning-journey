package com.doctorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DoctorDetailsDto {

	String doctorName;
	double fees;
	
}
