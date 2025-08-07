package com.projectToLearn.springProject.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
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
    productFromDb.setBrand(product.getBrand());
    productFromDb.setCategory(product.getCategory());
    productFromDb.setDescription(product.getDescription());
    productFromDb.setImages(product.getImages()); // deep set (need fix)
    productFromDb.setInventory(product.getInventory());
    productFromDb.setPrice(product.getPrice());
    return null;
  }

  @Override
  public List<Product> getProductsByBrand(String brand) {
    List<Product> products = new ArrayList<>();
    List<Product> productFromDb = this.productRepository.findAll();
    for(Product p : productFromDb){
      if(p.getBrand().equals(brand)){
        products.add(p);
      }
    }
    return products;
  }

  @Override
  public List<Product> getProductsByCategory(Category category) {
    List<Product> products = new ArrayList<>();
    List<Product> productFromDb = this.productRepository.findAll();
    for(Product p : productFromDb){
      if(p.getCategory().equals(category)){
        products.add(p);
      }
    }
    return products;
  }

  @Override
  public List<Product> getProductsByName(String name) {
    List<Product> products = new ArrayList<>();
    List<Product> productFromDb = this.productRepository.findAll();
    for(Product p : productFromDb){
      if(p.getName().equals(name)){
        products.add(p);
      }
    }
    return products;
  }
  
}
