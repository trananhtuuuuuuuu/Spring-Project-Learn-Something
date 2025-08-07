package com.projectToLearn.springProject.service.product;

import java.util.List;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.dto.ProductDto;
import com.projectToLearn.springProject.request.AddProductRequest;
import com.projectToLearn.springProject.request.UpdateProductRequest;

public interface IProductService {

  List<Product> getAllProducts();




  
  Product getProductById(Long id);





  Product saveProduct(AddProductRequest product);




  Product updateProductById(Long id, UpdateProductRequest product);




  void deleteProductById(Long id);




  List<Product> getProductsByCategoryName(Category category);




  List<Product> getProductsByName(String name);



  List<Product> getProductsByBrand(String brand);


  List<Product> getProductsByBrandAndName(String brand, String name);


  List<Product> getProductByCategoryNameAndBrand(Category category, String brand);


  List<ProductDto> getConvertedProducts(List<Product> products);


  Long getCountByBrandAndName(String brand, String name);




}
