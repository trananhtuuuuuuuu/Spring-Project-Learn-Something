package com.projectToLearn.springProject.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDtoResponse {
  private ProductDto productDto;
  private ShopDto shopDto;
}
