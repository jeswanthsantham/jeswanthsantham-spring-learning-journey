package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
	@Autowired
	private IProductService productservice;
	@Override
	public void run(String... args) throws Exception {
		ProductDto productDto = new ProductDto("pen", null, "classmate", "stationary", 200 );
		productservice.addProduct(productDto);
		productDto= new ProductDto("Football", null, "Nike", "Sports", 220);
		productservice.addProduct(productDto);
		productDto= new ProductDto("shoes", null, "Nike", "Sports", 4220);
		productservice.addProduct(productDto);
		productDto= new ProductDto("Tennisball", null, "Cosco", "Sports", 520);
		productservice.addProduct(productDto);
		productDto= new ProductDto("Notebook", null, "Classmate", "Stationary", 120);
		productservice.addProduct(productDto);
		productDto= new ProductDto("Basketball", null, "Cosco", "Sports", 1220);
		productservice.addProduct(productDto);
		
		System.out.println();
		productservice.getAll().stream().forEach(System.out::println);
		
		System.out.println();
		ProductDto nproduct = productservice.getById(1L);
		System.out.println(nproduct);
		
		System.out.println();
		// for updating
		nproduct.setProductName("Ballpoint pen");
		nproduct.setPrice(240);
		productservice.updateProduct(nproduct);
		
		System.out.println();
//		productservice.deleteProduct(5);
		
//		System.out.println("By brand");
//		productservice.getByBrand("Cosco").stream().forEach(System.out::println);
//		System.out.println();
//		
//		
//		System.out.println("By lesser price");
//		productservice.getByLesserPrice(3000).stream().forEach(System.out::println);
//		System.out.println();
//		
		System.out.println("By categoryandNameContains ");
		productservice.getBycategoryandNameContains("Sports", "Ball").stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("By cat");
		productservice.getByCategory("Sports").stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("By brand and price ");
		productservice.getByBrandAndLessPrice("Nike", 2000).stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("By name contains ");
		productservice.getByNameContains("ball").stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("By brand and category");
		productservice.getByBrandAndCategory("Cosco","Sports").stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("By greater price ");
		productservice.getByGreaterPrice(1000).stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Update product");
		productservice.updateProduct(1, 560);
		System.out.println();
		
		System.out.println("Sorting");
		productservice.getSortedProducts("brand").stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Paging");
		productservice.getPagedProducts(1,4).stream().forEach(System.out::println);
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
