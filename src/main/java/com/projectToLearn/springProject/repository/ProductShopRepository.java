package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.domain.ProductShop;
import com.projectToLearn.springProject.domain.Shop;


@Repository
public interface ProductShopRepository extends JpaRepository<ProductShop, Long> {
  boolean existsByProductAndShop(Product product, Shop shop);
}
