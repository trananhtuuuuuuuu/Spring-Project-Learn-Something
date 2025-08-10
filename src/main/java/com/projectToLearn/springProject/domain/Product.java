package com.projectToLearn.springProject.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // This is field saying that Identity of product and primary key
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="brand")
  private String brand;

  @Column(name="price")
  private BigDecimal price;

  @Column(name="inventory")
  private int inventory;

  @Column(name="description")
  private String description;

  @ManyToOne
  @JoinColumn(name="category_id")
  private Category category;

  @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<ProductShop> productShops;


  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<CartDetail> cartDetails;



  public Product(String name, 
  String brand, 
  BigDecimal price, 
  int inventory, 
  String description, 
  Category category) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.inventory = inventory;
    this.description = description;
    this.category = category;
  }

  

}
