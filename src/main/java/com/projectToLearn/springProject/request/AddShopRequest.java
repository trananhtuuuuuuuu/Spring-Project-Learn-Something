package com.projectToLearn.springProject.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddShopRequest {
  private String name;
  private String address;
}
