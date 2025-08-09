package com.projectToLearn.springProject.service.role;

import com.projectToLearn.springProject.domain.Role;

public interface IRoleService {
  Role getRoleByName(String roleName);
}
