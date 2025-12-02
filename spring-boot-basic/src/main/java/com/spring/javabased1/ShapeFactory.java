package com.spring.javabased1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ShapeFactory {
    @Autowired
    @Qualifier("myrectangle")
	private IShape shape;

	public void printArea(String choice, int x, int y) {
		System.out.println("Printing Area");

		shape.area(x, y);

	}

}
