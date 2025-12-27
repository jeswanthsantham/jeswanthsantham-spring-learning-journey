package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
