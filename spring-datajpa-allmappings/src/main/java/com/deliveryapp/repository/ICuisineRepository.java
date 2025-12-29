package com.deliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryapp.model.Cuisine;

public interface ICuisineRepository extends JpaRepository<Cuisine, Integer>{

}
