package com.projectToLearn.springProject.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseCount<T> {
  private Object message;
  private Long count;
  private T data;
}
