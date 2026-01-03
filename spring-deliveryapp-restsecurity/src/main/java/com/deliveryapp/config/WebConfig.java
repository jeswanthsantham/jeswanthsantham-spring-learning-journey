package com.deliveryapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {

//	@Autowired
//	private ApiUserServiceImpl userServiceImpl;
//	//2 beans
//	//authentication
//	@Bean
//	UserDetailsService userDetailsService() {
//		return userServiceImpl;
//	}
	//password encode
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	AuthenticationManager authenticate(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
//	//authentication provider
//	@Bean
//	DaoAuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userServiceImpl);
//		provider.setPasswordEncoder(encoder());
//		return provider; 
//	}
	//authorization
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		return http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((httpRequest)->{
			httpRequest
				//for user with the role admin and user
				.requestMatchers("/delivery-api/v1/restaurants/**","/delivery-api/v1/cuisines/**",
						"/delivery-api/v1/brands/**").hasAnyAuthority("ADMIN","USER")
				//for user with the role admin
				.requestMatchers("/delivery-api/v1/admin/**").hasAuthority("ADMIN")
				
				//everyone can access this url
				.requestMatchers("/user-api/v1/apiusers/register").permitAll()
				.anyRequest().authenticated();
			})
		.httpBasic(Customizer.withDefaults())
		.build();
	}
	
	
}
