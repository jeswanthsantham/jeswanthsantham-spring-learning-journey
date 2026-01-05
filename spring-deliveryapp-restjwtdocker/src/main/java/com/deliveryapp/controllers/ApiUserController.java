package com.deliveryapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryapp.mapper.DeliveryMapper;
import com.deliveryapp.model.JwtUser;
import com.deliveryapp.model.JwtUserRequest;
import com.deliveryapp.service.impl.JwtUserServiceImpl;
import com.deliveryapp.util.JwtTokenUtil;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/user-api/v1")
public class ApiUserController {

	JwtUserServiceImpl userServiceImpl;
	PasswordEncoder encoder;
	DeliveryMapper mapper;
	JwtTokenUtil tokenUtil;

//	http://localhost:8080/user-api/v1/register
	@PostMapping("/register")
	ResponseEntity<Void> createUser(@RequestBody JwtUserRequest userRequest) {
		System.out.println(userRequest);
		// encode the password
		String password = encoder.encode(userRequest.getPassword());
		// set the encoded password
		userRequest.setPassword(password);
		// convert dto to entity
		JwtUser apiUser = mapper.toUserEntity(userRequest);
		// call the method of service
		userServiceImpl.createUser(apiUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PostMapping("/authenticate")
	ResponseEntity<String> authenticateUser(@RequestBody JwtUserRequest userRequest) {
		System.out.println(userRequest);
		// check if username exists in the db
		UserDetails userDetails = userServiceImpl.loadUserByUsername(userRequest.getUsername());
//		  generate a jwt token using JwtTokenUtil
		String token = tokenUtil.generateToken(userDetails);
//		  return the token
		return ResponseEntity.ok(token);
	}

}
