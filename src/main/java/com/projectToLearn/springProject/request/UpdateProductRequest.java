package com.projectToLearn.springProject.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String brand;

  @NotNull(message = "Price is required")
  private BigDecimal price;

  @NotNull(message = "Inventory is required")
  private Integer inventory;

  @NotNull
  @NotEmpty
  private String description;

  @NotNull
  @NotEmpty
  private String categoryName;
}
