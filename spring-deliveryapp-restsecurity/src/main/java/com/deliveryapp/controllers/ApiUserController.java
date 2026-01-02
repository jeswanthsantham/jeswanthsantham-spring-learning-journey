package com.deliveryapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.ApiUser;
import com.deliveryapp.model.ApiUserRequest;
import com.deliveryapp.service.impl.ApiUserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user-api/v1")
@RequiredArgsConstructor
public class ApiUserController {
	
	private final PasswordEncoder passwordEncoder;
	private final DeliveryMapper mapper;
	private final ApiUserServiceImpl userServiceImpl;
	
	
	@PostMapping("/apiusers/register")
	ResponseEntity<Void> createUser(@RequestBody ApiUserRequest userRequest){
		
		String password = userRequest.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		userRequest.setPassword(encodedPassword);
		// convert userRequest into user
		  ApiUser apiUser = mapper.toUserEntity(userRequest);
		
		// call the method of ApiUserServiceImple to save the user object
		  // apiUser upcasted to UserDetails object
		userServiceImpl.createUser(apiUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
