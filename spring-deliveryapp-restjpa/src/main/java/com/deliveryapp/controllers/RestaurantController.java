package com.deliveryapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryapp.model.RestaurantRequest;
import com.deliveryapp.model.RestaurantResponse;
import com.deliveryapp.service.IRestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/delivery-api/v1")
@RequiredArgsConstructor
public class RestaurantController {
	
	private final IRestaurantService restaurantService;
	
	// http://localhost:8080/delivery-api/v1/restaurants
	@PostMapping("/restaurants")
	ResponseEntity<Void> createRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
		restaurantService.addRestaurant(restaurantRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Creating a list of restaurants "+restaurantRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
	}
	
	
	// http://localhost:8080/delivery-api/v1/restaurants
	@PutMapping("/restaurants")
	ResponseEntity<Void> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
		restaurantService.updateRestaurant(restaurantRequest);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	// http://localhost:8080/delivery-api/v1/restaurants/restaurantid/1
	@DeleteMapping("/restaurants/restaurantid/{restaurantId}")
	ResponseEntity<Void> deleteRestaurant(@PathVariable int restaurantId) {
		restaurantService.deleteRestaurant(restaurantId);
		return ResponseEntity.ok().build();
		
	}
	
	// http://localhost:8080/delivery-api/v1/restaurants
	@GetMapping("/restaurants")
	ResponseEntity<List<RestaurantResponse>> getAll(){
		
		List<RestaurantResponse> restaurants= restaurantService.getAll();
		//header,status,body
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", "API returning a list of restaurants");
		httpHeaders.add("description", "Returning a list of restaurants");
		return ResponseEntity.ok().headers(httpHeaders).body(restaurants);
		
		}
	// http://localhost:8080/delivery-api/v1/restaurants/id?restaurantId=2
	@GetMapping("/restaurants/id")
	ResponseEntity<RestaurantResponse> getById(@RequestParam int restaurantId) {
		RestaurantResponse restaurant = restaurantService.getById(restaurantId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Returning one restaurants");
		return new ResponseEntity<RestaurantResponse>(restaurant, httpHeaders, HttpStatus.OK.value());
				
	}
	// http://localhost:8080/delivery-api/v1/restaurants/city/Chennai
	@GetMapping("/restaurants/city/{city}")
	ResponseEntity<List<RestaurantResponse>> getByCity(@PathVariable String city){
		List<RestaurantResponse> restaurants = restaurantService.getByCity(city);
		return ResponseEntity.ok(restaurants);
		}

}
