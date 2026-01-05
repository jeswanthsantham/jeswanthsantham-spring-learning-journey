package com.deliveryapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebConfig {
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
 
	 //AuthenticationManager
	@Bean
	AuthenticationManager authenticate(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(httpRequest->{
				httpRequest
				.requestMatchers("/delivery-api/v1/restaurants/**",
						"/delivery-api/v1/cuisines/**","/delivery-api/v1/brands").hasAnyAuthority("ADMIN","USER")
				.requestMatchers("/delivery-api/v1/admin/**").hasAuthority("ADMIN")
				.requestMatchers("/user-api/v1/register","/user-api/v1/authenticate").permitAll()
			    .anyRequest().authenticated();
			})
			//handle exception
			.exceptionHandling(configurer->configurer.authenticationEntryPoint(jwtAuthenticationEntryPoint))
			//handle session
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			//call the filter before this
			.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
			.build();
	}


}











