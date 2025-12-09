package com.restaurantapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.model.Category;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        RestaurantDto restaurantDto = new RestaurantDto("A2B", null, "Bengaluru", Cuisine.SI.getCuisine(), Category.VEG.name());		
	}

}
