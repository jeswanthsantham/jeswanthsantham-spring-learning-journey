package com.deliveryapp.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.deliveryapp.model.JwtUser;
import com.deliveryapp.repository.IJwtUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class JwtUserServiceImpl implements UserDetailsManager{
	
	IJwtUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 JwtUser apiuser =  userRepository.findByUsername(username)
		  .orElseThrow(()-> new UsernameNotFoundException("invalid name"));
		 UserDetails userDetails = new User(apiuser.getUsername(), apiuser.getPassword(),apiuser.getAuthorities());
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		userRepository.save((JwtUser)user);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
