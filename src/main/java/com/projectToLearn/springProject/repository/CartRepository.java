package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectToLearn.springProject.domain.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  
}
