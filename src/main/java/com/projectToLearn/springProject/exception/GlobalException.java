package com.projectToLearn.springProject.exception;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projectToLearn.springProject.response.ApiErrorResponse;



@ControllerAdvice
public class GlobalException {

  @ExceptionHandler(IdNotFoundException.class)
  public ResponseEntity<Object> handleNotFoundUserId(IdNotFoundException ex){
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
    apiErrorResponse.setError("Id Error");
    apiErrorResponse.setMessage(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
  }


  @ExceptionHandler(value={
    ResourceNotFoundException.class,
    BadCredentialsException.class
  })
  public ResponseEntity<Object> handleNotValidLoginException(Exception ex){
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
    apiErrorResponse.setError(ex.getMessage());
    apiErrorResponse.setMessage("Invalid login");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
  }

  @ExceptionHandler(AlreadyExistsExeption.class)
  public ResponseEntity<Object> handleUserAlreadyExists(AlreadyExistsExeption ex){
    ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
      "Email already exists", ex.getMessage()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidUserLogin(
    MethodArgumentNotValidException ex
  ){
    BindingResult bResult = ex.getBindingResult();
    final List<FieldError> fieldErrors = bResult.getFieldErrors();


    ApiErrorResponse response = new ApiErrorResponse();

    response.setError(ex.getBody().getDetail());

    List<String> errors = new ArrayList<>();
    for(FieldError f : fieldErrors){
       errors.add(f.getDefaultMessage());
    }
    if(errors.size() > 1){
      response.setMessage(errors);
    }
    else{
      response.setMessage(errors.get(0));
    }
    


    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

}
