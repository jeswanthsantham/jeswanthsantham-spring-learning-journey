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

import com.deliveryapp.model.BrandRequest;
import com.deliveryapp.model.BrandResponse;
import com.deliveryapp.service.IBrandService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/delivery-api/v1")
@RequiredArgsConstructor
public class BrandController {

	private final IBrandService brandService;

//	http://localhost:8080/delivery-api/v1/brands
	@PostMapping("/admin/brands")
	ResponseEntity<Void> addBrand(@RequestBody BrandRequest brandRequest) {
		brandService.addBrand(brandRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Adding a new brand ");
		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
	}

//	http://localhost:8080/delivery-api/v1/brands
	@PutMapping("/admin/brands")
	ResponseEntity<Void> updateBrand(@RequestBody BrandRequest brandRequest) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

//		http://localhost:8080/delivery-api/v1/brands/brandid/1
	@DeleteMapping("/admin/brands/brandid/{brandId}")
	ResponseEntity<Void> deleteBrand(@PathVariable int brandId) {
		brandService.deleteBrand(brandId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
//	http://localhost:8080/delivery-api/v1/brands
	@GetMapping("/admin/brands")
	ResponseEntity<List<BrandResponse>> getAll() {
		List<BrandResponse> brands =  brandService.getAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("info", " API to return a list of brands");
		return ResponseEntity.ok().headers(httpHeaders).body(brands);
		
	}
//	http://localhost:8080/delivery-api/v1/brands/id/1
	@GetMapping("/admin/brands/id/{brandId}")
	ResponseEntity<BrandResponse> getById(@PathVariable int brandId) {
		BrandResponse brand =  brandService.getById(brandId);
		return ResponseEntity.status(HttpStatus.OK).body(brand);
	}

}
