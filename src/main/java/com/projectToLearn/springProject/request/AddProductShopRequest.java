package com.projectToLearn.springProject.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddProductShopRequest {
  private String nameShop;
  private String nameProduct;
  private String nameBrand;
}
