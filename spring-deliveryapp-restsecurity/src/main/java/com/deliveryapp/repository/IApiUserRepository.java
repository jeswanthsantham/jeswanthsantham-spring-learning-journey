package com.deliveryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deliveryapp.model.ApiUser;

public interface IApiUserRepository extends JpaRepository<ApiUser, Long> {
	
	
	@Query("from ApiUser au left join fetch au.roles where au.username=?1")
	Optional<ApiUser> findByUsername(String username);

}