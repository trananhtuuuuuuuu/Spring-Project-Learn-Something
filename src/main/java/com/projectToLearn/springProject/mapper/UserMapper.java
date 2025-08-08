package com.projectToLearn.springProject.mapper;

import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.dto.UserDto;

public class UserMapper {
  public User userDtoToUser(
    UserDto userDto){
    return new User(
      userDto.getFirstName(),
      userDto.getLastName(),
      userDto.getEmail(),
      userDto.getPassword()
    );
  }


  public UserDto userToUserDto(
    User user
  ){
    return new UserDto(
      user.getId(),
      user.getFirstName(),
      user.getLastName(),
      user.getEmail()
    );
  }
}
