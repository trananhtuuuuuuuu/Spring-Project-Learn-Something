package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.dto.UserDtoResponse;
import com.projectToLearn.springProject.dto.UserLoginDto;

import com.projectToLearn.springProject.exception.ResourceNotFoundException;
import com.projectToLearn.springProject.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@AllArgsConstructor
public class AutheticationLogin {

  private final UserRepository userRepository;
  private final AuthenticationManagerBuilder autheticationManagerBuilder;


  @PostMapping("/login")
  public ResponseEntity<Object> postAutheticationUSer(
    @Valid @RequestBody UserLoginDto userLoginDto
    ) {
      // get User already in database
      User user = this.userRepository.findByEmail(userLoginDto.getUserName())
      .orElseThrow(() -> new ResourceNotFoundException("failed login"));
      
      //triggers user's userName and password into security
      UsernamePasswordAuthenticationToken autheticationToken = 
      new UsernamePasswordAuthenticationToken(userLoginDto.getUserName(), userLoginDto.getPassword());

      // authetication that needing write loadUserByUsername function
      Authentication authetication = autheticationManagerBuilder
      .getObject()
      .authenticate(autheticationToken);

      UserDtoResponse userDtoResponse = new UserDtoResponse(
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getRole().getName()
      );
    return ResponseEntity.status(HttpStatus.CREATED).body(userDtoResponse);
  }





  @GetMapping("/")
  public String getMethodName() {
      return "Hello";
  }

  @GetMapping("/login")
  public String getLogin() {
      return "Hello from login path";
  }
  
  
}
