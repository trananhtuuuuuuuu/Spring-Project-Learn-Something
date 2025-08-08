package com.projectToLearn.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectToLearn.springProject.domain.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
  Role findByName(String name);
}
