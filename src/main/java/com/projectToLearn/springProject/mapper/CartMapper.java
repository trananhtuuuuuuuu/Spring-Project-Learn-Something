package com.projectToLearn.springProject.mapper;

import org.springframework.stereotype.Component;

import com.projectToLearn.springProject.domain.Cart;
import com.projectToLearn.springProject.dto.CartDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CartMapper {
  public CartDto cartToCartDto(Cart cart){
    return new CartDto(
      cart.getDatePlaced(),
      cart.getTotalAmount()
    );
  }


  public Cart cartDtotoCart(CartDto cartDto){
    return new Cart(
      cartDto.getDatePlaced(),
      cartDto.getTotalAmount()
    );
  }
}
