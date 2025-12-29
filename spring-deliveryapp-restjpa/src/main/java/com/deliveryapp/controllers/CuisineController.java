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

import com.deliveryapp.model.CuisineRequest;
import com.deliveryapp.model.CuisineResponse;
import com.deliveryapp.service.ICuisineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/delivery-api/v1")
@RequiredArgsConstructor
public class CuisineController {

	private final ICuisineService cuisineService;

	// http://localhost:8080/delivery-api/v1/cuisines
	@PostMapping("/cuisines")
	ResponseEntity<Void> addCuisine(@RequestBody CuisineRequest cuisineRequest) {
		cuisineService.addCuisine(cuisineRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Creating a list of cuisines " + cuisineRequest);

		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();

	}
	// http://localhost:8080/delivery-api/v1/cuisines
		@PutMapping("/cuisines")
		ResponseEntity<Void> updateCuisine(@RequestBody CuisineRequest cuisineRequest) {
			cuisineService.updateCuisine(cuisineRequest);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
		// http://localhost:8080/delivery-api/v1/cuisines/cuisineid/1
		@DeleteMapping("/cuisines/cuisineid/{cuisinesId}")
		ResponseEntity<Void> deleteCuisine(@PathVariable int cuisineId) {
			cuisineService.deleteCuisine(cuisineId);
			return ResponseEntity.ok().build();
	}

		// http://localhost:8080/delivery-api/v1/cuisines
		@GetMapping("/cuisines")
		ResponseEntity<List<CuisineResponse>> getAll() {
			List<CuisineResponse> cuisines= cuisineService.getAll();
			//header,status,body
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("info", "API returning a list of cuisines");
			httpHeaders.add("description", "Returning a list of cuisines");
			return ResponseEntity.ok().headers(httpHeaders).body(cuisines);
	}

		// http://localhost:8080/delivery-api/v1/cuisines/id?cuisineId=2
		@GetMapping("/cuisines/id")
		ResponseEntity<CuisineResponse> getById(@RequestParam int cuisineId) {
			CuisineResponse cuisine = cuisineService.getById(cuisineId);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("description", "Returning one cuisines");
			return new ResponseEntity<CuisineResponse>(cuisine, httpHeaders, HttpStatus.OK.value());
					
	}

}
