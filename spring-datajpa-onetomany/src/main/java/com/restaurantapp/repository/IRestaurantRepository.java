package com.restaurantapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantapp.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
	

}
