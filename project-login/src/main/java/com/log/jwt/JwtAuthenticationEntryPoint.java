package com.log.jwt;
import java.io.IOException;
//import java.io.PrintWriter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint
{
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException 
	{
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied !!");
//		PrintWriter writer = response.getWriter();
//		writer.println("Access Denied !!" + authException.getMessage());
	}

	public JwtAuthenticationEntryPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
