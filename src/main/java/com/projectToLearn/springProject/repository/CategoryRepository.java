package com.projectToLearn.springProject.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.projectToLearn.springProject.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
