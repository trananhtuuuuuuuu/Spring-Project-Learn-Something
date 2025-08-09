package com.projectToLearn.springProject.service.user;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projectToLearn.springProject.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Component("userDetailsService")
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

  private final UserService userService;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    com.projectToLearn.springProject.domain.User user = this.userService.getUserByEmail(username);
    if(user.equals(null)){
      throw new ResourceNotFoundException("User not found");
    }
    return new User(
      user.getEmail(),
      user.getPassword(),
      Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
    );
  }
  
}
