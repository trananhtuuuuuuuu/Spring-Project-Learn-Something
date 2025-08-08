package com.projectToLearn.springProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

  Long id;
  String firstName;
  String lastName;
  String email;
  String password;

  public UserDto(
    String email,
    String password
  ){
    this.email = email;
    this.password = password;
  }

  public UserDto(
    Long id,
    String firstName,
    String lastName,
    String email
  ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

}
