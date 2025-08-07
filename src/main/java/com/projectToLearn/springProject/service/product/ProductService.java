package com.projectToLearn.springProject.service.product;


import java.util.List;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.dto.ProductDto;
import com.projectToLearn.springProject.repository.ProductRepository;
import com.projectToLearn.springProject.request.AddProductRequest;
import com.projectToLearn.springProject.request.UpdateProductRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService implements IProductService {

  private ProductRepository productRepository;




  @Override
  public void deleteProductById(Long id) {
   // Todo
  }







  @Override
  public List<Product> getAllProducts() {
    return this.productRepository.findAll();
  }







  @Override
  public Product getProductById(Long id) {
    return null; // Todo
  }








  @Override
  public Product saveProduct(AddProductRequest product) {
    return null; // Todo
  }










  @Override
  public Product updateProductById(Long id, UpdateProductRequest product) {
    return null; // Todo
  }












  @Override
  public List<Product> getProductsByBrand(String brand) {
    return this.productRepository.findByBrand(brand);
  }











  @Override
  public List<Product> getProductsByCategoryName(Category category) {
    return this.productRepository.findByCategoryName(category.getName());
  }













  @Override
  public List<Product> getProductsByName(String name) {
    return this.productRepository.findByName(name);
  }












  @Override
  public List<Product> getProductByCategoryNameAndBrand(Category category, 
  String brand) {
    return this.productRepository.findByCategoryNameAndBrand(category.getName(), brand);
  }












  @Override
  public List<Product> getProductsByBrandAndName(String brand, String name) {
    return this.productRepository.findByBrandAndName(brand, name);
  }










  @Override
  public Long getCountByBrandAndName(String brand, String name) {
    return this.productRepository.countByBrandAndName(brand, name);
  }







  @Override
  public List<ProductDto> getConvertedProducts(List<Product> products) {
    return null; // Todo
  }









  
}
