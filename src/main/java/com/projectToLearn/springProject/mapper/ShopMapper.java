package com.projectToLearn.springProject.mapper;

import org.springframework.stereotype.Component;

import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ShopDto;


@Component
public class ShopMapper {



  public Shop shopDtoMapperShop(ShopDto shopDto){
    return new Shop(
      shopDto.getName(),
      shopDto.getAddress(),
      shopDto.getDateOriginal()
    );
  }


  public ShopDto shopMapperShopDto(Shop shop){
    return new ShopDto(
      shop.getName(),
      shop.getAddress(),
      shop.getDateOriginal()
    );
  }


}
