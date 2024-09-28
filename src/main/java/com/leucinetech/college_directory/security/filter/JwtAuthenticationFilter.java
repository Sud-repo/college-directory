package com.leucinetech.college_directory.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.leucinetech.college_directory.security.service.CustomUserDetailsService;
import com.leucinetech.college_directory.security.service.JwtTokenService;

/**
 * @author Sudharshan
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private JwtTokenService jwtTokenService;

	@Autowired
	private CustomUserDetailsService userDetailsService;



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getRequestURI().startsWith("/api/v1/auth/")) {
	        // Continue the filter chain without applying JWT validation
	        filterChain.doFilter(request, response);
	        return;
	    }

		// get JWT token from HTTP request
		String token = getTokenFromRequest(request);

		// validate token
		if (StringUtils.hasText(token) && jwtTokenService.validateToken(token)) {

			// get username from token
			String username = jwtTokenService.getUsername(token);

			// load the user associated with token
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());

			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		}

		filterChain.doFilter(request, response);
	}

	private String getTokenFromRequest(HttpServletRequest request) {

		String bearerToken = request.getHeader("Authorization");

		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		} else {
			return getJwtTokenFromCookie(request);
		}

	}

	
	private String getJwtTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwtToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
	
}
