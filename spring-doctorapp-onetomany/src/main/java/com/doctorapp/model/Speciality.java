package com.doctorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Speciality {
	PHYSICIAN("General Physician"),
	INTERNAL("Internal Medicine"),
	COSDENTIST("Cosmetic dentist"),
	DENTIST("Dentist"),
	NEURO("Neurologist"),
	DERMA("Dermatologist");
	
	private String speciality;
}
