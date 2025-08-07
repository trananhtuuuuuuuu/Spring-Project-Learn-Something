package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectToLearn.springProject.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
  
}
