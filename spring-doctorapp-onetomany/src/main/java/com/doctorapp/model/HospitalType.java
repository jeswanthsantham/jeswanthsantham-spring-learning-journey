package com.doctorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HospitalType {

	wc("WOMEN\'S AND CHILDREN HOSPITAL"),
	ortho("ORTHO CLINIC"),
	child("CHILDREN\'S HOSPITAL"),
	ent("ENT CLINIC"),
	eye("EYE CLINIC"),
	dia("DIABETIC HOSPITAL");
	
	private String hospitalType;
	
}
