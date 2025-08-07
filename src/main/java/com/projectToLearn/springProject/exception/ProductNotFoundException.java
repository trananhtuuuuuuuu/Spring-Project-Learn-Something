package com.projectToLearn.springProject.exception;

public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(String message){
    super(message);
  }
}
