package com.projectToLearn.springProject.dto;

import java.math.BigDecimal;

import com.projectToLearn.springProject.domain.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDto {
  private Long id;

  private int quantity;

  private BigDecimal unitPrice;

  private BigDecimal subtotal;

  private Cart cart;
}
