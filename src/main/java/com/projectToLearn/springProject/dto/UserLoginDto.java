package com.projectToLearn.springProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserLoginDto {
  
  @NotBlank(message = "username must not empty")
  private String userName;

  @NotBlank(message = "password must not empty")
  private String password;
}
