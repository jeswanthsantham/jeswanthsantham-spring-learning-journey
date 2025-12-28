package com.greetapp.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	
	@GetMapping("/greet")
	public String greetUser(Model model) {
		//from here call the service
		//service returns the data
		String data = "Have a great day";
		// create a model from the data
		// attach the data to the model by giving a dummy name
		model.addAttribute("message", data);
		// the data is send to the view with the dummy name
		// return the view page name
		return "hello"; // the view page name
	}

	@GetMapping("/say-hello")
	public String helloUser(ModelMap model) {
		//from here call the service
		//service returns the data
		String data = "Hello... Welcome to Spring MVC";
		// create a model from the data
		// attach the data to the model by giving a dummy name
		model.addAttribute("message", data);
		// the data is send to the view with the dummy name
		// return the view page name
		return "hello"; // the view page name
	}
	
	@GetMapping("/welcome")
	public ModelAndView welcomeUser() {
		//from here call the service
		// create a model from the data
		ModelAndView modelAndView = new ModelAndView("hello","date",LocalDate.now());
		return modelAndView;
	}
}
