package com.projectToLearn.springProject.exception;

public class IllegalArgumentException extends RuntimeException{
  public IllegalArgumentException(String mess){
    super(mess);
  }
}
