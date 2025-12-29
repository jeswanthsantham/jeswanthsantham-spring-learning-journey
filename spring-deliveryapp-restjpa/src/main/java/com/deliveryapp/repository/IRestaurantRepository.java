package com.deliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryapp.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
