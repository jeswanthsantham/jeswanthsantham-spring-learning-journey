package com.spring.javabased1;


public class Square implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Area of Square: " +(x*x));

	}

}
