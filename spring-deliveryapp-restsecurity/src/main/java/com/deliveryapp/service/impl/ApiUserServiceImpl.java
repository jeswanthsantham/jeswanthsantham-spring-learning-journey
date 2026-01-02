package com.deliveryapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.deliveryapp.model.ApiUser;
import com.deliveryapp.repository.IApiUserRepository;

@Service
public class ApiUserServiceImpl implements UserDetailsManager {
	@Autowired
	private IApiUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
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
