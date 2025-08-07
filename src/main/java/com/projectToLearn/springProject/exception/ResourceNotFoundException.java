package com.projectToLearn.springProject.exception;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String message){
    super(message);
  }
}
