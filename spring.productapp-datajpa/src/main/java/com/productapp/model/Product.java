package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter, setter, tostring, hashcode etc
@Entity
//@Table(name="product_detail")
public class Product {

	@Column(length = 20)
	private String productName;
	@Id
	@GeneratedValue
	private Long productId;
	@Column(length = 20)
	private String brand;
	@Column(length = 20)
	private String category;
	@Column(name = "cost")
	private double price;

}
