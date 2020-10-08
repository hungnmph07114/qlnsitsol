package com.qlnsitsol.demo.Service;

import com.qlnsitsol.demo.entity.Role;
import com.qlnsitsol.demo.enums.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> getByRoleName(RoleName roleName);
    void save(Role role);
}
