package com.projectToLearn.springProject.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="quantity")
  private int quantity;

  @Column(name="unit_price")
  private BigDecimal unitPrice;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name="shop_id")
  private Shop shop;

  @ManyToOne
  @JoinColumn(name="producct_id")
  private Product product;
}
