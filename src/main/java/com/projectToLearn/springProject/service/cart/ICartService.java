package com.projectToLearn.springProject.service.cart;

import java.math.BigDecimal;

import com.projectToLearn.springProject.domain.Cart;

public interface ICartService {
  Cart getCartById(Long id);

  Cart deleteCartById(Long id);

  BigDecimal getTotalAmountCart(Long id);
}
