package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectToLearn.springProject.domain.ProductShop;


@Repository
public interface ProductShopRepository extends JpaRepository<ProductShop, Long> {
  
}
