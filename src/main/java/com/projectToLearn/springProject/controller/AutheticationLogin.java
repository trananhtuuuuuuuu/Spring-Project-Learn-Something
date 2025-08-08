package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.dto.UserDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AutheticationLogin {

  @PostMapping("/login")
  public ResponseEntity<Object> postAuth(
    @RequestBody UserDto userDto
    ) {

    return ResponseEntity.ok().body(null);
  }
  
}
