package com.deliveryapp.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CuisineRequest {
	private Integer cuisineId;
	@Enumerated(EnumType.STRING)
	private Cuisines cuisineName; //northindian,italian
	
	

}





