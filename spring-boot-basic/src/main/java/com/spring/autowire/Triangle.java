package com.spring.autowire;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Area of a Triangle: " + (0.5 * x * y));

	}

}
