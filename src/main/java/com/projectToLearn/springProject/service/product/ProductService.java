package com.projectToLearn.springProject.service.product;

import java.util.List;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements IProductService {

  private ProductRepository productRepository;
  @Override
  public void deleteProductById(Long id) {
    this.productRepository.deleteById(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return this.productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    return this.productRepository.findById(id).get();
  }

  @Override
  public Product saveProduct(Product product) {
    return this.productRepository.save(product);
  }

  @Override
  public Product updateProductById(Long id, Product product) {
    Product productFromDb = this.productRepository.findById(id).get();
    productFromDb.setName(product.getName());
    productFromDb.setBrand(null);
    return null;
  }

  @Override
  public List<Product> getProductsByBrand(String brand) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Product> getProductsByCategory(Category category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Product> getProductsByName(String name) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
