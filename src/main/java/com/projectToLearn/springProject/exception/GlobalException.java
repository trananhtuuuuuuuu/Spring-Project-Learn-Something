package com.projectToLearn.springProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projectToLearn.springProject.response.ApiErrorResponse;

@ControllerAdvice
public class GlobalException {
  @ExceptionHandler(AlreadyExistsExeption.class)
  public ResponseEntity<Object> handleUserAlreadyExists(AlreadyExistsExeption ex){
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
      "Email already exists", ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
  }

}
