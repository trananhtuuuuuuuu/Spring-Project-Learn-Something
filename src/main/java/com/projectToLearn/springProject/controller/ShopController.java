package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ShopDto;
import com.projectToLearn.springProject.mapper.ShopMapper;
import com.projectToLearn.springProject.request.AddShopRequest;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.shop.ShopService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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


  @GetMapping("/api/shops")
  public ResponseEntity<Object> getAllShops() {
    ApiResponse<List<ShopDto>> apiresponse = new ApiResponse<List<ShopDto>>();

    List<Shop> shops = this.shopService.getShops();
    List<ShopDto> shopDtos = new ArrayList<>();

    for(Shop s : shops){
      shopDtos.add(this.shopMapper.shopMapperShopDto(s));
    }

    apiresponse.setMessage("Successfully get all shops");
    apiresponse.setData(shopDtos);

    return ResponseEntity.ok(apiresponse);
  }


  @PutMapping("/api/shops/{shopId}")
  public ResponseEntity<Object> updatedShopById(
    @PathVariable Long shopId,
    @RequestBody ShopDto shopDto) {
    
    ApiResponse<ShopDto> apiResponse = new ApiResponse<ShopDto>();
    
    Shop shop = this.shopService.updateShopById(shopId, shopDto);

    apiResponse.setMessage("Successfully updated Shop");
    apiResponse.setData(this.shopMapper.shopMapperShopDto(shop));
    
    return ResponseEntity.ok(apiResponse);
  }


  @DeleteMapping("api/shops/{shopId}")
  public ResponseEntity<Object> deleteShopById(
    @PathVariable Long shopId
  ){


    ApiResponse<ShopDto> apiResponse = new ApiResponse<ShopDto>();

    Shop shop = this.shopService.deleteShopById(shopId);

    apiResponse.setMessage("Successfully delete Shop");
    apiResponse.setData(this.shopMapper.shopMapperShopDto(shop));

    return ResponseEntity.ok(apiResponse);

  }


  
  
  
}
