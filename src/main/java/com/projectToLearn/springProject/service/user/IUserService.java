package com.projectToLearn.springProject.service.user;

import java.util.List;

import com.projectToLearn.springProject.domain.User;

public interface IUserService {
  List<User> getAllUsers();

  User getUserById(Long id);

  User getUserByEmail(String email);

  User saveUser(User user);

  void deleteUserById(Long id);

  User updateUserById(Long id, User user);


}
