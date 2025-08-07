package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectToLearn.springProject.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
