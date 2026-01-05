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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/delivery-api/v1")
@RequiredArgsConstructor
@Tag(name = "Restaurant Controller", description ="has rest end points of restaurant")
public class RestaurantController {
	
//	To run the swagger ui
//	http://localhost:8080/swagger-ui/index.html
	
	private final IRestaurantService restaurantService;
	
//	http://localhost:8080/delivery-api/v1/restaurants
	
	@PostMapping("/admin/restaurants")
	ResponseEntity<Void>  createRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest){
		restaurantService.addRestaurant(restaurantRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Creating a new restaurant "+restaurantRequest);
		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
		
	}
//	http://localhost:8080/delivery-api/v1/restaurants
	@PutMapping("/admin/restaurants") 
	ResponseEntity<Void> updateRestaurant(@RequestBody  @Valid RestaurantRequest restaurantRequest){
		restaurantService.updateRestaurant(restaurantRequest);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
//	http://localhost:8080/delivery-api/v1/restaurants/restaurantid/1
	@DeleteMapping("/admin/restaurants/restaurantid/{restaurantId}")
	ResponseEntity<Void> deleteRestaurant(@PathVariable int restaurantId){
		restaurantService.deleteRestaurant(restaurantId);
		return ResponseEntity.ok().build();
	}
	
//	http://localhost:8080/delivery-api/v1/restaurants
	@Operation(operationId = "getAllRestaurants",
			   summary = "Getting list of restaurants",
			   description = "This rest end point is used to return a list of restaurants")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description=" returns a list of restaurants",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = RestaurantResponse.class)) )
	})
	@GetMapping("/restaurants")
	ResponseEntity<List<RestaurantResponse>> getAll(){
		List<RestaurantResponse> restaurants= restaurantService.getAll();
		//header,status, body
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", " API to return a list of restaurants");
		httpHeaders.add("description", "Returning a list of restaurants");
		return ResponseEntity.ok().headers(httpHeaders).body(restaurants);
		
		
	}
//	http://localhost:8080/delivery-api/v1/restaurants/id?restaurantId=2
	@GetMapping("/restaurants/id")
	ResponseEntity<RestaurantResponse> getById(@RequestParam int restaurantId){
		RestaurantResponse restaurant = restaurantService.getById(restaurantId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Returning one restaurant");
		return new ResponseEntity<RestaurantResponse>(restaurant, httpHeaders, HttpStatus.OK.value());
		
		
	}
//	http://localhost:8080/delivery-api/v1/restaurants/city/Chennai
	@GetMapping("/restaurants/city/{city}")
	ResponseEntity<List<RestaurantResponse>> getByCity(@PathVariable String city){
		List<RestaurantResponse> restaurants= restaurantService.getByCity(city);
		return ResponseEntity.ok(restaurants);
	}
}














