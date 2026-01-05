package com.deliveryapp.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.deliveryapp.service.impl.JwtUserServiceImpl;
import com.deliveryapp.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

	JwtTokenUtil tokenUtil;
	JwtUserServiceImpl userServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = null;
		String token = null;
		// get the request header
		String header = request.getHeader("Authorization");
		// check if header starts with bearer
		if (header != null && header.startsWith("Bearer ")) {
			// get the token from the header Bearer <token>
			token = header.substring(7);
			// get the username from the token
			try {
				username = tokenUtil.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
			}
		} // if this header is not available
		else
			logger.warn("invalid token");
		// header is available and username is not null
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// check if username is in the database
			UserDetails userDetails = userServiceImpl.loadUserByUsername(username);
			// validate the token -
			boolean validToken = tokenUtil.validateToken(token, userDetails);
			// if it is valid
			if (validToken) {
				// create an authentication token
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				// set the authentication in the context
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		System.out.println("......I am here...........");
		filterChain.doFilter(request, response);

	}

}
