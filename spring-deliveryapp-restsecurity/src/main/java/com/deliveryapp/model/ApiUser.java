package com.deliveryapp.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiUser implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@Id
	@GeneratedValue
	private Long userId;
	
	@ElementCollection
	@CollectionTable(name="apiuser_roles",
	                 joinColumns = @JoinColumn(name="role"))
	
	private Set<String> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//Set<String> roles = getRoles();
//		convert Set<roles> into Set<GrantedAuthority>
		//individual String values -. convert to GrantedAuthority
		/*
		roles.stream().map(roles->{
			GrantedAuthority auth = new SimpleGrantedAuthority(roles);
			return auth;
		}).toList();
		
		roles.stream().map(role ->{
			return new SimpleGrantedAuthority(role);
		}).toList()
		*/
		return roles.stream().map(roles->new SimpleGrantedAuthority(roles)).toList();
		
	}

}
