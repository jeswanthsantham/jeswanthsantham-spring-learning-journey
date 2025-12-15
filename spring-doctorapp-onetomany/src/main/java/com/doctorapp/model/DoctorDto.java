package com.doctorapp.model;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {
	private Integer doctorId;
	private String doctorName;
	
	private String email;
	private double fees;
	private int experience;
	private String speciality;
	private AddressDto address;
	private List<LocalTime> availability;
	
	
	
	
	

}
