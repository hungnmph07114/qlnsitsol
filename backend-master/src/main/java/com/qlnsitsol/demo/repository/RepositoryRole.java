package com.qlnsitsol.demo.repository;
import com.qlnsitsol.demo.entity.Role;
import com.qlnsitsol.demo.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryRole extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
