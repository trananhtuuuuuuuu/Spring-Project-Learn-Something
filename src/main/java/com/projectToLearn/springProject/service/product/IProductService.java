package com.projectToLearn.springProject.service.product;

import java.util.List;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;

public interface IProductService {

  List<Product> getAllProducts();




  
  Product getProductById(Long id);





  Product saveProduct(Product product);




  Product updateProductById(Long id, Product product);




  void deleteProductById(Long id);




  List<Product> getProductsByCategory(Category category);




  List<Product> getProductsByName(String name);



  List<Product> getProductsByBrand(String brand);
}
