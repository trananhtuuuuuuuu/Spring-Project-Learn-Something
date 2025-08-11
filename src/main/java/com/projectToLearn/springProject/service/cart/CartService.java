package com.projectToLearn.springProject.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Cart;
import com.projectToLearn.springProject.exception.IdNotFoundException;
import com.projectToLearn.springProject.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService implements ICartService{

  private final CartRepository cartRepository;

  @Override
  public Cart deleteCartById(Long id) {
    Cart cart = this.cartRepository.findById(id)
    .orElseThrow(() -> new IdNotFoundException("Not found"));
    this.cartRepository.deleteById(id);
    return cart;
  }

  @Override
  public Cart getCartById(Long id) {
    return this.cartRepository.findById(id).orElseThrow(
      () -> new IdNotFoundException("Not found")
    );
  }

  @Override
  public BigDecimal getTotalAmountCart(Long id) {
    Cart cart = this.cartRepository.findById(id)
    .orElseThrow(
      () -> new IdNotFoundException("Not Found")
    );
    return cart.getTotalAmount();
  }
  
}
