package com.spring.javabased1;


public class Triangle implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Area of a Triangle: " + (0.5 * x * y));

	}

}
