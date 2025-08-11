package com.projectToLearn.springProject.service.product;



import java.util.List;


import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.domain.Product;

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
    ); 
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
    Product productFromDb = this.productRepository.findById(id).orElseThrow(
      () -> new ProductNotFoundException("Update product Error")
    );
    Category category = this.categoryRepository.findByName(product.getCategoryName());

    //Map<String, String> map = new HashMap<>();

    
    if(product.getBrand() != null){
      productFromDb.setBrand(product.getBrand());
    }
    if(product.getCategoryName() != null){
      productFromDb.setCategory(category);
    }
    if(product.getName() != null){
      productFromDb.setName(product.getName());
    }
    if(product.getPrice() != null){
      productFromDb.setPrice(product.getPrice());
    }
    if(product.getInventory() != null){
      productFromDb.setInventory(product.getInventory());
    }
    if(product.getDescription() != null){
      productFromDb.setDescription(product.getDescription());
    }
    

    return this.productRepository.save(productFromDb); 
  }




  @Override
  public List<Product> getProductsByBrand(String brand) {
    return this.productRepository.findByBrand(brand);
  }



  // @Override
  // public Product getProductsByCategoryName(String categoryName) {
  //   return this.productRepository.findByCategoryName(categoryName);
  // }



  @Override
  public List<Product> getProductsByCategoriesName(String category) {
    return this.productRepository.findByCategoryName(category);
  }


  @Override
  public List<Product> getProductsByName(String name) {
    return this.productRepository.findByName(name);
  }



  @Override
  public List<Product> getProductByCategoryNameAndBrand(String category, 
  String brand) {
    return this.productRepository.findByCategoryNameAndBrand(category, brand);
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
  public Long getCountProductByBrand(String brand) {
    return this.productRepository.countByBrand(brand);
  }


  @Override
  public Long getCountProductByName(String name) {
    return this.productRepository.countByName(name);
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
