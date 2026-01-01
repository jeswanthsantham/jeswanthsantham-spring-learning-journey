package com.deliveryapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiUserRequest {
	
	private String username;
	private String password;
	private Long userId;
	private Set<String> roles;

}
