package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectToLearn.springProject.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
