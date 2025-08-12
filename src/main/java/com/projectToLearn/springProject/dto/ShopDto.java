package com.projectToLearn.springProject.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ShopDto {
  private String name;
  private String address;
  private LocalDate dateOriginal;
}
