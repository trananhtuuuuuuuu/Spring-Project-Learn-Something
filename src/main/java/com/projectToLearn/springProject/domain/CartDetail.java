package com.projectToLearn.springProject.domain;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class CartDetail {

  private Long id;
  private int quantity;
  private BigDecimal unitPrice;

  @ManyToOne
  @JoinColumn(name="cart_id")
  private Cart cart;

  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name="shop_id")
  private Shop shop;
}
