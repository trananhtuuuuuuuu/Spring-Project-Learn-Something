package com.projectToLearn.springProject.mapper;

import org.springframework.stereotype.Component;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.dto.ProductDto;
import com.projectToLearn.springProject.service.category.CategoryService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductMapper {

  private final CategoryService categoryService;


  public ProductDto ProductMapperProductDto(Product product){
    return new ProductDto(
      product.getId(),
      product.getName(),
      product.getBrand(),
      product.getPrice(),
      product.getInventory(),
      product.getDescription(),
      product.getCategory().getName()
    );
  }


  public Product productDtoMapperProduct(ProductDto productDto){
    Category category = this.categoryService.getCategoriesByName(productDto.getCategoryName());
    return new Product(
      productDto.getName(),
      productDto.getBrand(),
      productDto.getPrice(),
      productDto.getInventory(),
      productDto.getDescription(),
      category
    );
  }


}
