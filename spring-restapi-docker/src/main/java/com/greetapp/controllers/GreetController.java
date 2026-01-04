package com.greetapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	//  http://localhost:8080/greet
	//rest endpoint using Http Get method
	@GetMapping("/greet")
	public String greet(){
		return "Have a great day";
	}
	
	
	//Data comes in the url
	//http://localhost:8080/welcome/Jeswanth
	@GetMapping("/welcome/{username}")
	public String welcomeUser(@PathVariable String username){
		return "Welcome "+username;
	}
	
	//data comes from a form
	//http://localhost:8080/show?n1=Sai&n2=Shirdi
	@GetMapping("/show")
	public String showDetails(@RequestParam("n1") String username,@RequestParam String city) {
		return "Welcome "+ username +" from "+city;
	}
	
	@GetMapping("/show-books")
	public List<String> showBooks(){
		return List.of("Atomic Habits", "the 5 am club");
		
	}

}
