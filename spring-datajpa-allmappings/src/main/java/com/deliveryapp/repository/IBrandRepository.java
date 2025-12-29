package com.deliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryapp.model.Brand;

public interface IBrandRepository extends JpaRepository<Brand, Integer>{

}
