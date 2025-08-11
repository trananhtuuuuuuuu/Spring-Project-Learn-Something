package com.projectToLearn.springProject.service.product;



import java.util.List;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.dto.ProductDto;
import com.projectToLearn.springProject.exception.ProductNotFoundException;
import com.projectToLearn.springProject.repository.CategoryRepository;
import com.projectToLearn.springProject.repository.ProductRepository;
import com.projectToLearn.springProject.request.AddProductRequest;
import com.projectToLearn.springProject.request.UpdateProductRequest;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService implements IProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;


  @Override
  public void deleteProductById(Long id) {
    Product product = this.productRepository.findById(id).orElseThrow(
      () -> new ProductNotFoundException("Product not found")
    );
    product.setBrand("null");
    this.productRepository.deleteById(id);
  }


  @Override
  public List<Product> getAllProducts() {
    return this.productRepository.findAll();
  }


  @Override
  public Product getProductById(Long id) {
    return this.productRepository.findById(id).orElseThrow(
      () -> new ProductNotFoundException("Product Not Found Id")
    ); // Todo
  }


  @Override
  public Product addProduct(AddProductRequest addProductRequest) {
    Category category = this.categoryRepository.findByName(addProductRequest.getCategoryName());
    if(category == null){
      Category categoryNew = new Category(addProductRequest.getCategoryName());
      this.categoryRepository.save(categoryNew);
      return this.productRepository.save(this.createProduct(addProductRequest, categoryNew));
    }
    Product product = this.createProduct(addProductRequest, category);
    return this.productRepository.save(product); 
  }



  @Override
  public Product createProduct(AddProductRequest addProductRequest, Category category) {
    return new Product(
      addProductRequest.getName(),
      addProductRequest.getBrand(),
      addProductRequest.getPrice(),
      addProductRequest.getInventory(),
      addProductRequest.getDescription(),
      category
    );
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
  public Product getProductsByCategoryName(Category category) {
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


  @Override
  public boolean alreadyProduct(Product product) {
    Product productFromDb = this.productRepository.findByBrandAndNameAndPriceAndInventoryAndDescription(
      product.getBrand(), 
      product.getName(),
      product.getPrice(),
      product.getInventory(), 
      product.getDescription());

    return productFromDb != null;
  }









  
}
