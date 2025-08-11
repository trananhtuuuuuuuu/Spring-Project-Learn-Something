package com.projectToLearn.springProject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

  private String datePlaced;

  private BigDecimal totalAmount = BigDecimal.ZERO;
}
