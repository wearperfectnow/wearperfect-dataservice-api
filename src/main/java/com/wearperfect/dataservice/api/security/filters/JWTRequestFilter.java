package com.wearperfect.dataservice.api.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wearperfect.dataservice.api.security.models.WearperfectUserDetails;
import com.wearperfect.dataservice.api.security.service.WearperfectUserDetailsService;
import com.wearperfect.dataservice.api.security.service.JwtUtiilService;

@Component
public class JWTRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtUtiilService jwtUtiilService;
	
	@Autowired
	WearperfectUserDetailsService wearperfectUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authorization = request.getHeader("Authorization");
		String userId = null;
		String jwt = null;
		
		if(null != authorization && !authorization.trim().isEmpty() && authorization.startsWith("Bearer ")) {
			jwt = authorization.substring(7);
			userId = jwtUtiilService.extractUserId(jwt);
		}
		
		if(null != userId && SecurityContextHolder.getContext().getAuthentication() == null) {
			WearperfectUserDetails userDetails = wearperfectUserDetailsService.loadUserByUserId(Long.valueOf(userId));
			if(jwtUtiilService.validateToken(jwt, userDetails)) {
				System.out.println("User "+userDetails.getUsername()+" authorized succesfully");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				System.out.println("Autentication obj: "+SecurityContextHolder.getContext().getAuthentication().getName());
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
