package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.dto.UserDtoResponse;
import com.projectToLearn.springProject.mapper.UserMapper;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.user.UserService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@AllArgsConstructor
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/api/admin/users")
  public ResponseEntity<Object> getAllUsers() {
    ApiResponse<List<UserDtoResponse>> apiResponse = new ApiResponse<List<UserDtoResponse>>();
    List<User> users = this.userService.getAllUsers();
    List<UserDtoResponse> res = new ArrayList<>();
    for(User user : users){
      res.add(this.userMapper.userToUserDtoResponse(user));
    }
    if(users.isEmpty()){
      apiResponse.setMessage("Users were empty");
    }
    else{
      apiResponse.setMessage("Successful");
    }
    apiResponse.setData(res);
    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }
  
}
