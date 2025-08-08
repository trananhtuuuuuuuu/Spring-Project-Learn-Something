package com.projectToLearn.springProject.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.exception.AlreadyExistsExeption;
import com.projectToLearn.springProject.exception.ResourceNotFoundException;
import com.projectToLearn.springProject.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
  
  private final UserRepository userRepository;
  
  @Override
  public void deleteUserById(Long id) throws ResourceNotFoundException{
    // TODO
    User user = this.userRepository.findById(id)
                                   .orElseThrow(() -> new ResourceNotFoundException(
                                    "User not found"
                                   ));
    user.setFirstName("Deleted");
    this.userRepository.deleteById(id);
  }

  @Override
  public List<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  @Override
  public User getUserByEmail(String email) throws ResourceNotFoundException{
    return this.userRepository.findByEmail(email)
    .orElseThrow(new ResourceNotFoundException("Email not found"));
  }

  @Override
  public User getUserById(Long id) throws ResourceNotFoundException{
    return this.userRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("User not found")
    );
  }

  @Override
  public User saveUser(User user) throws AlreadyExistsExeption{
    if(this.userRepository.existsByEmail(user.getEmail())){
      new AlreadyExistsExeption("Already email");
    }
    return this.userRepository.save(user);
  }

  @Override
  public User updateUserById(Long id, User user) throws ResourceNotFoundException{
    User userFromDb = this.userRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("User not found")
    );
    userFromDb.setFirstName(user.getFirstName());
    userFromDb.setLastName(user.getLastName());
    userFromDb.setEmail(user.getEmail());
    
    return userFromDb;
  }
  
}
