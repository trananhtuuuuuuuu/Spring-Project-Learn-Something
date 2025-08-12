package com.projectToLearn.springProject.service.shop;

import java.time.LocalDate;


import java.util.List;
import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.dto.ShopDto;
import com.projectToLearn.springProject.exception.IdNotFoundException;
import com.projectToLearn.springProject.repository.ShopRepository;
import com.projectToLearn.springProject.request.AddShopRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShopService implements IShopService {

  private final ShopRepository shopRepository;

  @Override
  public Shop addShop(AddShopRequest addShopRequest) {

    if (addShopRequest == null) {
        throw new IllegalArgumentException("Shop cannot be null");
    }


    if (addShopRequest.getName() == null || addShopRequest.getName().trim().isEmpty()) {
        throw new IllegalArgumentException("Shop name is required");
    }


    if (addShopRequest.getAddress() == null || addShopRequest.getAddress().trim().isEmpty()) {
        throw new IllegalArgumentException("Shop address is required");
    }

    Shop shopExiststing = this.shopRepository.findByNameAndAddress(addShopRequest.getName(), 
    addShopRequest.getAddress());

    if(shopExiststing != null){
      throw new IllegalArgumentException("Shop with this name or address already exists");
    }

    Shop shop = new Shop(
        addShopRequest.getName(),
        addShopRequest.getAddress(),
        LocalDate.now()
    );

    return this.shopRepository.save(shop);
  }

  @Override
  public Shop deleteShopById(Long id) {
    Shop shop = this.shopRepository.findById(id).orElseThrow(
      () -> new IdNotFoundException("Id not found")
    );
    this.shopRepository.deleteById(id);
    return shop;
  }

  @Override
  public List<Shop> getShopByAddress(String address) {
    return this.shopRepository.findByAddress(address);
  }

  @Override
  public Shop getShopById(Long id) {
    return this.shopRepository.findById(id).orElseThrow(
      () -> new IdNotFoundException("Id not found")
    );
  }

  

  

  @Override
  public List<Shop> getShopByName(String name) {
    return this.shopRepository.findByName(name);
  }

  @Override
  public List<Shop> getShops() {
    return this.shopRepository.findAll();
  }

  @Override
  public int[][] convertDateToMonthAndYear(String date) {
    String str[] = date.split("/");
    Integer month = Integer.parseInt(str[1]);
    Integer year = Integer.parseInt(str[2]);
    int[][] arr = new int[1][2];
    arr[0][0] = month;
    arr[0][1] = year;
    return arr;
  }

  @Override
  public List<Shop> getShopByMonthAndYearOrigin(int month, int year) {
    return this.shopRepository.findByMonthAndYear(month, year);
  }

  @Override
  public List<Shop> getShopByYearOrigin(int year) {
    return this.shopRepository.findByYear(year);
  }

  @Override
  public Shop updateShopById(Long id, ShopDto shopDto) {
    Shop shopFromDb = this.shopRepository.findById(id).orElseThrow(
      () -> new IdNotFoundException("Not found id")
    );
    if(shopDto.getName() != null){
      shopFromDb.setName(shopDto.getName());
    }

    if(shopDto.getAddress() != null){
      shopFromDb.setAddress(shopDto.getAddress());
    }

    if(shopDto.getDateOriginal() != null){
      shopFromDb.setDateOriginal(shopDto.getDateOriginal());
    }
    return this.shopRepository.save(shopFromDb);
  }
  
}
