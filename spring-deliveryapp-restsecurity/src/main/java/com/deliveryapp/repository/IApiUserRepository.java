package com.deliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryapp.model.ApiUser;

public interface IApiUserRepository extends JpaRepository<ApiUser, Long> {

}