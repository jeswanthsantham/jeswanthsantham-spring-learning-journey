package com.restaurantapp.model;

public enum Cuisine {
	NI("NORTH INDIAN"), SI("SOUTH INDIAN"), CHINESE("CHINESE"),
	ITALIAN("ITALIAN"), MEXICAN("MEXICAN");

	private String Cuisine;

	private Cuisine(String cuisine) {
		this.Cuisine = cuisine;

	}

	public String getCuisine() {
		return Cuisine;
	}

}
