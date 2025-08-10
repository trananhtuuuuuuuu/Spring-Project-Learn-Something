package com.projectToLearn.springProject.exception;

public class EmailNotValidException extends RuntimeException{
  public EmailNotValidException(String mess){
    super(mess);
  }
}
