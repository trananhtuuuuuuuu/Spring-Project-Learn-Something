package com.projectToLearn.springProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.dto.ProductDto;

import com.projectToLearn.springProject.mapper.ProductMapper;
import com.projectToLearn.springProject.request.AddProductRequest;
import com.projectToLearn.springProject.request.UpdateProductRequest;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.response.ApiResponseCount;
import com.projectToLearn.springProject.service.product.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@AllArgsConstructor
public class ProductController {

  private final ProductService productService;
  private final ProductMapper productMapper;



  @PostMapping("/api/products")
  public ResponseEntity<Object> createProducts(
    @Valid @RequestBody AddProductRequest addProductRequest,
    BindingResult bindingResult
    ) {
    
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(
          bindingResult.getAllErrors().stream()
              .map(ObjectError::getDefaultMessage)
              .collect(Collectors.toList())
        );
    }
    Product product = this.productService.addProduct(addProductRequest);

    ApiResponse<ProductDto> apiResponse = new ApiResponse<ProductDto>();

    apiResponse.setMessage("Created successful product");
    apiResponse.setData(this.productMapper.ProductMapperProductDto(product));


    return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }


  @PutMapping("/api/products/{productId}")
  public ResponseEntity<Object> putUpdateProduct(
    @PathVariable Long productId, 
    @RequestBody UpdateProductRequest updateProductRequest) {

      ApiResponse<ProductDto> apiResponse = new ApiResponse<ProductDto>();

      Product product = this.productService.updateProductById(productId, updateProductRequest);

      apiResponse.setMessage("Updated successfully");
      apiResponse.setData(this.productMapper.ProductMapperProductDto(product));

      return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }
  


  @DeleteMapping("/api/products/{productId}")
  public ResponseEntity<Object> deleteProductId(@PathVariable Long productId){
    ApiResponse<ProductDto> apiResponse = new ApiResponse<ProductDto>();
    Product product = this.productService.getProductById(productId);

    apiResponse.setMessage("Deleted successful product");
    apiResponse.setData(this.productMapper.ProductMapperProductDto(product));

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products")
  public ResponseEntity<Object> getAllProducts() {

    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();
    List<Product> products = this.productService.getAllProducts();
    List<ProductDto> productDtos = new ArrayList<>();
    for(Product p : products){
      ProductDto productDto = this.productMapper.ProductMapperProductDto(p);
      productDtos.add(productDto);
    }
    apiResponse.setMessage("Successful get all products");
    apiResponse.setData(productDtos);
    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/brand")
  public ResponseEntity<Object> getProductsByBrand(
    @RequestParam String brand
    ) {
    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();

    List<Product> products = this .productService.getProductsByBrand(brand);

    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponse.setMessage("Successful get product by brand");
    apiResponse.setData(productDtos);

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/brand&name")
  public ResponseEntity<Object> getProductsByBrandAndName(
    @RequestParam String brand,
    @RequestParam String name
    ) {

    List<Product> products = this.productService.getProductsByBrandAndName(
      brand, name
    );
    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();

    apiResponse.setMessage("Successful API brand and name");
    apiResponse.setData(productDtos);

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/category")
  public ResponseEntity<Object> getProductByCategory(
    @RequestParam String category
  ){

    List<Product> products = this.productService.getProductsByCategoriesName(category);
    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }
    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();
    apiResponse.setMessage("Successful category");
    apiResponse.setData(productDtos);

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/name")
  public ResponseEntity<Object> getProductsByName(
    @RequestParam String name
  ) {

    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();

    List<Product> products = this.productService.getProductsByName(name);
    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponse.setMessage("Successful name");
    apiResponse.setData(productDtos);

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/category&brand")
  public ResponseEntity<Object> getProductsByCategoryNameAndBrand(
    @RequestParam String category,
    @RequestParam String brand
  ){

    ApiResponse<List<ProductDto>> apiResponse = new ApiResponse<List<ProductDto>>();

    List<Product> products = this.productService.getProductByCategoryNameAndBrand(
      category, brand
    );

    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponse.setMessage("Successful category and name");
    apiResponse.setData(productDtos);

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/products/count/brand&name")
  public ResponseEntity<Object> getCountByBrandAndName(
    @RequestParam String brand,
    @RequestParam String name
  ) {

  ApiResponseCount<List<ProductDto>> apiResponseCount = new ApiResponseCount<List<ProductDto>>();


    List<Product> products = this.productService.getProductsByBrandAndName(
      brand, name
    );

    Long countProduct = this.productService.getCountByBrandAndName(brand, name);

    List<ProductDto> productDtos = new ArrayList<>();
    
    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponseCount.setMessage("Successful brand and name");
    apiResponseCount.setCount(countProduct);
    apiResponseCount.setData(productDtos);

    return ResponseEntity.ok(apiResponseCount);
  }


  @GetMapping("/api/products/count/brand")
  public ResponseEntity<Object> getCountProductsByBrand(
    @RequestParam String brand
  ) {
    ApiResponseCount<List<ProductDto>> apiResponseCount = new ApiResponseCount<List<ProductDto>>();

    Long countProducts = this.productService.getCountProductByBrand(brand);

    List<Product> products = this.productService.getProductsByBrand(brand);

    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponseCount.setMessage("Successful Count By brand");
    apiResponseCount.setCount(countProducts);
    apiResponseCount.setData(productDtos);

    return ResponseEntity.ok(apiResponseCount);
  }


  @GetMapping("/api/products/count/name")
  public ResponseEntity<Object> getCountProductsByName(
    @RequestParam String name
  ) {
    ApiResponseCount<List<ProductDto>> apiResponseCount = new ApiResponseCount<List<ProductDto>>();

    Long countProducts = this.productService.getCountProductByName(name);

    List<Product> products = this.productService.getProductsByName(name);

    List<ProductDto> productDtos = new ArrayList<>();

    for(Product p : products){
      productDtos.add(this.productMapper.ProductMapperProductDto(p));
    }

    apiResponseCount.setMessage("Successful Count By name");
    apiResponseCount.setCount(countProducts);
    apiResponseCount.setData(productDtos);

    return ResponseEntity.ok(apiResponseCount);
  }
  
  
  
  
  
  
  
  
  
}
