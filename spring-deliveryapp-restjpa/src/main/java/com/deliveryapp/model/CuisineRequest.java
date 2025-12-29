package com.deliveryapp.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CuisineRequest {
	
	private Integer cuisineId;
	@Enumerated(EnumType.STRING)
	private Cuisines cuisineName; //northindian,italian
	
	

}





