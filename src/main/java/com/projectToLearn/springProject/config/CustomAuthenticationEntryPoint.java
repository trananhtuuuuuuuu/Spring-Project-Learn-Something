package com.projectToLearn.springProject.config;


import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectToLearn.springProject.response.ApiErrorResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

  private final AuthenticationEntryPoint delegate = new BearerTokenAuthenticationEntryPoint();
  private final ObjectMapper mapper;

  public CustomAuthenticationEntryPoint(ObjectMapper mapper){
    this.mapper = mapper;
  }

  @Override
  public void commence(HttpServletRequest request, 
  HttpServletResponse response, 
  AuthenticationException authException)
      throws IOException, ServletException {
    this.delegate.commence(request, response, authException);
    response.setContentType("application/json;charset=UTF-8");

    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();

    apiErrorResponse.setError(authException.getCause().getMessage());
    apiErrorResponse.setMessage("Token was not True");

    this.mapper.writeValue(response.getWriter(), apiErrorResponse);
  }
  
}
