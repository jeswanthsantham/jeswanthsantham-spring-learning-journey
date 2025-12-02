package com.spring.javabased1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ShapeConfig {
	
	@Bean
	@Primary
	@Scope("prototype") // new bean will be created
	Square mysquare() {
		return new Square();
	}

	@Bean
	Triangle mytriangle() {
		return new Triangle();
	}
	@Bean
	Rectangle myrectangle() {
		return new Rectangle();
	}
	@Bean
	ShapeFactory myShapeFactory() {
		return new ShapeFactory();
	}
}
