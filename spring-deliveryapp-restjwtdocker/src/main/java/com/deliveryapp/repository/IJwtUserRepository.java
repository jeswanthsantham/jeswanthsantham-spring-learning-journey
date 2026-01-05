package com.deliveryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deliveryapp.model.JwtUser;

public interface IJwtUserRepository extends JpaRepository<JwtUser, Long>{

	@Query("from JwtUser au left join fetch au.roles where au.username=?1")
	Optional<JwtUser> findByUsername(String username);
}
