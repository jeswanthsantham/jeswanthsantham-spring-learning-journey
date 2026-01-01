package com.deliveryapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.deliveryapp.service.impl.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	@Autowired
	private ApiUserServiceImpl userServiceImpl;
	//2 beans
	//authentication
	@Bean
	UserDetailsService userDetailsService() {
		return userServiceImpl;
	}
	
	
	//password encode
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	//authentication provider
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		return new DaoAuthenticationProvider(userServiceImpl);
	}
	//authorization
	
	
}
