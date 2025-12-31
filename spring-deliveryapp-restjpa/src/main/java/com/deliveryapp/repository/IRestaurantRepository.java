package com.deliveryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deliveryapp.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	
	@Query("from Restaurant r inner join r.address a where a.city=?1")
	List<Restaurant> findByCity(String city);

}
