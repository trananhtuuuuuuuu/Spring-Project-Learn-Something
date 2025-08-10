package com.projectToLearn.springProject.exception;

public class IdNotFoundException extends RuntimeException{
  public IdNotFoundException(String mess){
    super(mess);
  }
}
