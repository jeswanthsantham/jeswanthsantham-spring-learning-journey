package com.spring.javabased1;


public class Rectangle implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Area of Rectange " + (x * y));

	}

}
