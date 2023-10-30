package com.log.config;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager,
                                                      AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
        super();
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationDetailsSource(authenticationDetailsSource);
    }
}
