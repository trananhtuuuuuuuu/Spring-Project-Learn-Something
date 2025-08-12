package com.projectToLearn.springProject.service.shop;

import java.util.List;


import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ShopDto;
import com.projectToLearn.springProject.request.AddShopRequest;

public interface IShopService {
  Shop addShop(AddShopRequest shop);

  Shop deleteShopById(Long id);

  Shop updateShopById(Long id, ShopDto shopDto);

  List<Shop> getShops();

  List<Shop> getShopByAddress(String address);

  List<Shop> getShopByYearOrigin(int year);

  List<Shop> getShopByMonthAndYearOrigin(int month, int year);

  List<Shop> getShopByName(String name);

  Shop getShopById(Long id);

  int[][] convertDateToMonthAndYear(String date);

}
