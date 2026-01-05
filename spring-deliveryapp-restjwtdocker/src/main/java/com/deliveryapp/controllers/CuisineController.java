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

//	http://localhost:8080/delivery-api/v1/cuisines
	@PostMapping("/admin/cuisines")
	ResponseEntity<Void> addCuisine(@RequestBody CuisineRequest cuisineRequest) {
		cuisineService.addCuisine(cuisineRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Adding a new cuisine ");
		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
	}

//	http://localhost:8080/delivery-api/v1/cuisines
	@PutMapping("/admin/cuisines")
	ResponseEntity<Void> updateCuisine(@RequestBody CuisineRequest cuisineRequest) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

//		http://localhost:8080/delivery-api/v1/cuisines/cuisineid/1
	@DeleteMapping("/admin/cuisines/cuisineid/{cuisineId}")
	ResponseEntity<Void> deleteCuisine(@PathVariable int cuisineId) {
		cuisineService.deleteCuisine(cuisineId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
//	http://localhost:8080/delivery-api/v1/cuisines
	@GetMapping("/admin/cuisines")
	ResponseEntity<List<CuisineResponse>> getAll() {
		List<CuisineResponse> cuisines =  cuisineService.getAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", " API to return a list of cuisines");
		return ResponseEntity.ok().headers(httpHeaders).body(cuisines);
		
	}
//	http://localhost:8080/delivery-api/v1/cuisines/id/1
	@GetMapping("/cuisines/id/{cuisineId}")
	ResponseEntity<CuisineResponse> getById(@PathVariable int cuisineId) {
		CuisineResponse cuisine =  cuisineService.getById(cuisineId);
		return ResponseEntity.status(HttpStatus.OK).body(cuisine);
	}

}
