package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ShopDto;
import com.projectToLearn.springProject.mapper.ShopMapper;
import com.projectToLearn.springProject.request.AddShopRequest;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.shop.ShopService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class ShopController {

  private final ShopService shopService;
  private final ShopMapper shopMapper;

  @PostMapping("/api/shops")
  public ResponseEntity<Object> addShop(
    @RequestBody AddShopRequest addShopRequest
  ) {
      
    ApiResponse<ShopDto> apiResponse = new ApiResponse<ShopDto>();

  

    Shop savedShop = this.shopService.addShop(addShopRequest);
    
    apiResponse.setMessage("Successfully created shop");
    apiResponse.setData(this.shopMapper.shopMapperShopDto(savedShop));

    return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }
  
}
