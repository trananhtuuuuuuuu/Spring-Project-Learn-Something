package com.projectToLearn.springProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projectToLearn.springProject.domain.Cart;
import com.projectToLearn.springProject.dto.CartDto;
import com.projectToLearn.springProject.mapper.CartMapper;
import com.projectToLearn.springProject.response.ApiResponse;
import com.projectToLearn.springProject.service.cart.CartService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
public class CartController {

  private final CartService cartService;
  private final CartMapper cartMapper;

  @GetMapping("/api/carts/{cartId}")
  public ResponseEntity<Object> getCartById(
    @PathVariable Long cartId
  ) {

    ApiResponse<CartDto> apiResponse = new ApiResponse<CartDto>();
    Cart cart = this.cartService.getCartById(cartId);

    apiResponse.setMessage("Successful Cart");
    apiResponse.setData(this.cartMapper.cartToCartDto(cart));

    return ResponseEntity.ok(apiResponse);
  }

  @DeleteMapping("/api/carts/{cartId}")
  public ResponseEntity<Object> deleteCartId(
    @PathVariable Long cartId
  ){

    ApiResponse<CartDto> apiResponse = new ApiResponse<CartDto>();

    Cart cart = this.cartService.deleteCartById(cartId);
    
    apiResponse.setMessage("Successful deleted cart");
    apiResponse.setData(this.cartMapper.cartToCartDto(cart));

    return ResponseEntity.ok(apiResponse);
  }


  @GetMapping("/api/carts/totalAmount/{cartId}")
  public ResponseEntity<Object> getTotalAmountCart(
    @PathVariable Long cartId
  ) {
    ApiResponse<BigDecimal> apiResponse = new ApiResponse<BigDecimal>();

    apiResponse.setMessage("Successful ");
    apiResponse.setData(this.cartService.getTotalAmountCart(cartId));

    return ResponseEntity.ok(apiResponse);
  }
  
  
}
