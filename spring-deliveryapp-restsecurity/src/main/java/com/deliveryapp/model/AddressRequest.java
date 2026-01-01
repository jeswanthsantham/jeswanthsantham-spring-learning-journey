package com.deliveryapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequest {
	
	private Integer addressId;
	private String location;
	
	@NotBlank
	@Size(min=3, message = "city shouldhave 3 or more characters")
	private String city;
	private String state;

}

