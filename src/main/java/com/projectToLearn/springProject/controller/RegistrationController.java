package com.projectToLearn.springProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.Role;
import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.dto.UserDto;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.role.RoleService;
import com.projectToLearn.springProject.service.user.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RegistrationController {
  
  private final UserService userService;
  private final RoleService roleService;

  @PostMapping("/admin/registrations")
  public ResponseEntity<ApiResponse<UserDto>> postCreateUser(
    @RequestBody UserDto userDto
  ){
    User user = new User(userDto.getFirstName(),
    userDto.getLastName(),
    userDto.getEmail(),
    userDto.getPassword());
    Role role = this.roleService.getRoleByName(userDto.getRoleName());
    user.setRole(role);
    User savedUser = this.userService.saveUser(user);
    userDto.setFirstName(savedUser.getFirstName()); // avoid warning for savedUser varitable
    return ResponseEntity.status(HttpStatus.CREATED).body(
      new ApiResponse<UserDto>(
      "successful",
      userDto
    )
    );
  }









}
