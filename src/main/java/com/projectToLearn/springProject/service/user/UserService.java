package com.projectToLearn.springProject.service.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.User;
import com.projectToLearn.springProject.exception.AlreadyExistsExeption;
import com.projectToLearn.springProject.exception.EmailNotValidException;
import com.projectToLearn.springProject.exception.IdNotFoundException;
import com.projectToLearn.springProject.exception.ResourceNotFoundException;
import com.projectToLearn.springProject.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
  
  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;
  
  @Override
  public void deleteUserById(Long id) {
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
  public User getUserByEmail(String email) {
    if(!this.isValidEmail(email)){
      throw new EmailNotValidException("Wrong email");
    }

    if(!this.userRepository.existsByEmail(email)){
      throw new AlreadyExistsExeption("Not Already email");
    }
    
    return this.userRepository.findByEmail(email).get();
  }

  @Override
  public User getUserById(Long id) {
    return this.userRepository.findById(id).orElseThrow(
      () -> new IdNotFoundException("Id not found")
    );
  }

  @Override
  public User saveUser(User user) {

    if(!this.isValidEmail(user.getEmail())){
      new EmailNotValidException("Wrong email");
    }

    if(this.userRepository.existsByEmail(user.getEmail())){
      new AlreadyExistsExeption("Already email");
    }
    
    String hashPassword = this.passwordEncoder.encode(user.getPassword());
    user.setPassword(hashPassword);
    return this.userRepository.save(user);
  }

  @Override
  public User updateUserById(Long id, User user) {
    User userFromDb = this.userRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("User not found")
    );
    userFromDb.setFirstName(user.getFirstName());
    userFromDb.setLastName(user.getLastName());
    userFromDb.setEmail(user.getEmail());
    
    return userFromDb;
  }

  @Override
  public boolean isValidEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email != null && email.matches(emailRegex);
  }
  
}
