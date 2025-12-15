package com.doctorapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HospitalDto {
	
	private Integer hospitalId;
	private String hospitalName;
	private String hospitalType;
	private String city;
	Set<DoctorDto> doctors;

}
