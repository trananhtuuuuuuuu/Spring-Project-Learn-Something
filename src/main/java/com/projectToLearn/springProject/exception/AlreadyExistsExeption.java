package com.projectToLearn.springProject.exception;

public class AlreadyExistsExeption extends RuntimeException{
  public AlreadyExistsExeption(String message){
    super(message);
  }
}
