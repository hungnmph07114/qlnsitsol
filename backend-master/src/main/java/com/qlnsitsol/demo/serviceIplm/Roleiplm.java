package com.qlnsitsol.demo.serviceIplm;
import com.qlnsitsol.demo.Service.RoleService;
import com.qlnsitsol.demo.entity.Role;
import com.qlnsitsol.demo.enums.RoleName;
import com.qlnsitsol.demo.repository.RepositoryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Roleiplm implements RoleService {
    @Autowired
    RepositoryRole repositoryRole;
    @Override
    public Optional<Role> getByRoleName(RoleName roleName) {
        return repositoryRole.findByRoleName(roleName) ;
    }

    @Override
    public void save(Role role) {
        repositoryRole.save(role);

    }
}
