package com.projectToLearn.springProject.mapper;

import org.springframework.stereotype.Component;


import com.projectToLearn.springProject.domain.Role;
import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.dto.UserDto;
import com.projectToLearn.springProject.dto.UserDtoResponse;
import com.projectToLearn.springProject.dto.UserDtoUpdate;
import com.projectToLearn.springProject.service.role.RoleService;



@Component
public class UserMapper {
  private final RoleService roleService;
  
  public UserMapper(RoleService roleService) {
      this.roleService = roleService;
  }

  public User userDtoToUser(
    UserDto userDto){
    return new User(
      userDto.getFirstName(),
      userDto.getLastName(),
      userDto.getEmail(),
      userDto.getPassword()
    );
  }


  public User userDtoUpdateToUser(
    UserDtoUpdate userDtoUpdate
  ){
    Role role = this.roleService.getRoleByName(userDtoUpdate.getRole());
    User user = new User(
      userDtoUpdate.getFirstName(),
      userDtoUpdate.getLastName(),
      userDtoUpdate.getEmail(),
      role
    );
    return user;
  }


  public UserDto userToUserDto(
    User user
  ){
    return new UserDto(
      user.getId(),
      user.getFirstName(),
      user.getLastName(),
      user.getEmail(),
      user.getRole().getName()
    );
  }

  public UserDtoResponse userToUserDtoResponse(User user){
    return new UserDtoResponse(
      user.getFirstName(), 
      user.getLastName(), 
      user.getEmail(), 
      user.getRole().getName());
  }
}
