package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectToLearn.springProject.domain.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
  
}
