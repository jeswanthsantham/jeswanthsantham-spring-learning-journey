package com.deliveryapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.deliveryapp.model.ApiUser;
import com.deliveryapp.repository.IApiUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ApiUserServiceImpl implements UserDetailsManager {
	@Autowired
    IApiUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiuser = userRepository.findByUsername(username)
		.orElseThrow(()-> new UsernameNotFoundException("Invalid name"));
		UserDetails userDetails = new User(apiuser.getUsername(), apiuser.getPassword(), apiuser.getAuthorities());
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// downcast UserDetails object to apiUser
     userRepository.save((ApiUser)user);		
	}

	@Override
	public void updateUser(UserDetails user) {
		// downcast UserDetails object to apiUser
	     userRepository.save((ApiUser)user);		
	}

	@Override
	public void deleteUser(String username) {
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		
	}

	@Override
	public boolean userExists(String username) {
		return false;
	}
	
	

}
