package com.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequest {
	
	private Integer addressId;
	private String location;
	private String city;
	private String state;

}
