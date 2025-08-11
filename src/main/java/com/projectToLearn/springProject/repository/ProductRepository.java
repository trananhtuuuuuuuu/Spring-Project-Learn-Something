package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projectToLearn.springProject.domain.Product;

import java.math.BigDecimal;
import java.util.List;





public interface ProductRepository extends JpaRepository<Product, Long> {


  List<Product> findByBrand(String brand);




  Product findByCategoryName(String categoryName);



  List<Product> findByCategoryNameAndBrand(String categoryName, String brand);




  List<Product> findByName(String name);



  List<Product> findByBrandAndName(String brand, String name);




  Long countByBrandAndName(String brand, String name);


  Product findByBrandAndNameAndPriceAndInventoryAndDescription(String brand,
  String name, BigDecimal price, int inventory, String description);



}
