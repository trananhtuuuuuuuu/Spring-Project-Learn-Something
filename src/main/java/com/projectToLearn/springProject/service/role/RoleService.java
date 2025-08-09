package com.projectToLearn.springProject.service.role;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Role;
import com.projectToLearn.springProject.repository.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService{
  private final RoleRepository roleRepository;

  @Override
  public Role getRoleByName(String roleName) {
    return this.roleRepository.findByName(roleName);
  }
  
}
