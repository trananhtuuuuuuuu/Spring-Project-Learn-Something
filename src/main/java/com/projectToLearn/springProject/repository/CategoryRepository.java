package com.projectToLearn.springProject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectToLearn.springProject.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  boolean existsByName(String name);
  List<Category> findByName(String name);
}
