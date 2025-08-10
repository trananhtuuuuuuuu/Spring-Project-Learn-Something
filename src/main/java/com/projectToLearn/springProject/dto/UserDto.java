package com.projectToLearn.springProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

  Long id;
  String firstName;
  String lastName;
  String email;
  String password;
  String roleName;

  

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
    String email,
    String roleName
  ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roleName = roleName;
  }



  public UserDto(
    String firstName,
    String lastName,
    String email
  ){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }


  public UserDto(
    String firstName,
    String lastName,
    String email,
    String password,
    String roleName
  ){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roleName = roleName;
  }

}
