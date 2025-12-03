package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

	private String productName;
	private Long productId;
	private String brand;

	private String category;
	private double price;

}
