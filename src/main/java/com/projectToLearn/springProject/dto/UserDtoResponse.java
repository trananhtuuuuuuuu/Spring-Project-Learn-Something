package com.projectToLearn.springProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoResponse {
  private String firstName;
  private String lastName;
  private String email;
  private String role;
}
