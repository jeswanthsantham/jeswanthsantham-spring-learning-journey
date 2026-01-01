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

import com.deliveryapp.model.BrandRequest;
import com.deliveryapp.model.BrandResponse;
import com.deliveryapp.service.IBrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/delivery-api/v1")
@RequiredArgsConstructor
public class BrandController {

	private final IBrandService brandService;

	// http://localhost:8080/delivery-api/v1/brands
	@PostMapping("/brands")
	ResponseEntity<Void> addBrand(@RequestBody BrandRequest brandRequest) {
		brandService.addBrand(brandRequest);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("description", "Creating a list of brands " + brandRequest);

		return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();

	}
	// http://localhost:8080/delivery-api/v1/brands
		@PutMapping("/brands")
		ResponseEntity<Void> updateBrand(@RequestBody BrandRequest brandRequest) {
			brandService.updateBrand(brandRequest);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
		// http://localhost:8080/delivery-api/v1/brands/brandid/1
		@DeleteMapping("/brands/brandid/{brandsId}")
		ResponseEntity<Void> deleteBrand(@PathVariable int brandId) {
			brandService.deleteBrand(brandId);
			return ResponseEntity.ok().build();
	}

		// http://localhost:8080/delivery-api/v1/brands
		@GetMapping("/brands")
		ResponseEntity<List<BrandResponse>> getAll() {
			List<BrandResponse> brands= brandService.getAll();
			//header,status,body
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("info", "API returning a list of brands");
			httpHeaders.add("description", "Returning a list of brands");
			return ResponseEntity.ok().headers(httpHeaders).body(brands);
	}

		// http://localhost:8080/delivery-api/v1/brands/id?brandId=2
		@GetMapping("/brands/id")
		ResponseEntity<BrandResponse> getById(@RequestParam int brandId) {
			BrandResponse brand = brandService.getById(brandId);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("description", "Returning one brands");
			return new ResponseEntity<BrandResponse>(brand, httpHeaders, HttpStatus.OK.value());
					
	}

}

