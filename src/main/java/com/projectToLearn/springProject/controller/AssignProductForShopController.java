package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;


import com.projectToLearn.springProject.domain.ProductShop;
import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ProductDto;
import com.projectToLearn.springProject.dto.ProductDtoResponse;
import com.projectToLearn.springProject.dto.ShopDto;
import com.projectToLearn.springProject.mapper.ProductMapper;
import com.projectToLearn.springProject.mapper.ShopMapper;
import com.projectToLearn.springProject.request.AddProductShopRequest;

import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.productShop.ProductShopService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
public class AssignProductForShopController {
  private final ProductShopService productShopService;
  private final ShopMapper shopMapper;
  private final ProductMapper productMapper;

  @PostMapping("/api/productShops")
  public ResponseEntity<Object> createProductShop(
    @RequestBody AddProductShopRequest addProductShopRequest
  ) {
    
    ApiResponse<ProductDtoResponse> apiResponse = new ApiResponse<ProductDtoResponse>();

    ProductShop productShop = this.productShopService.saveProductShop(addProductShopRequest);
    
    ProductDto productDto = this.productMapper.ProductMapperProductDto(productShop.getProduct());
    Shop shop = productShop.getShop();

    

    ProductDtoResponse productDtoResponse = new ProductDtoResponse(
      productDto,
      this.shopMapper.shopMapperShopDto(shop)
    );


    apiResponse.setMessage("Successfully assign product for shop");
    apiResponse.setData(productDtoResponse);
    

    return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }


  @PutMapping("/api/productShops/{productShopId}")
  public ResponseEntity<Object> updateProductShopById(
    @PathVariable Long productShopId, 
    @RequestBody AddProductShopRequest addProductShopRequest) {

    ApiResponse<ProductDtoResponse> apiResponse = new ApiResponse<ProductDtoResponse>();

    ProductShop productShop = this.productShopService.updateProductShopById(
      productShopId, addProductShopRequest
    );

    ProductDto productDto = this.productMapper.ProductMapperProductDto(
      productShop.getProduct()
    );

    ShopDto shopDto = this.shopMapper.shopMapperShopDto(
      productShop.getShop()
    );

    ProductDtoResponse productDtoResponse = new ProductDtoResponse(
      productDto,
      shopDto
    );

    apiResponse.setMessage("Successfully");
    apiResponse.setData(productDtoResponse);


    return ResponseEntity.ok(apiResponse);
  }

  @DeleteMapping("/api/productShops/{productShopId}")
  public ResponseEntity<Object> deleteProductShopById(
    @PathVariable Long productShopId
  ){

    ProductShop productShop = this.productShopService.deleteProductShopById(productShopId);
    ApiResponse<ProductDtoResponse> apiResponse = new ApiResponse<>();
    
    ProductDtoResponse productDtoResponse = new ProductDtoResponse(
      this.productMapper.ProductMapperProductDto(productShop.getProduct()), 
      this.shopMapper.shopMapperShopDto(productShop.getShop())
    );

    apiResponse.setMessage("Successfully deleted");
    apiResponse.setData(productDtoResponse);

    return ResponseEntity.ok(apiResponse);
  }
  
}
