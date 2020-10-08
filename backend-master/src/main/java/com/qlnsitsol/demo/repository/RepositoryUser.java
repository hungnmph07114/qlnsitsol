package com.qlnsitsol.demo.repository;
import com.qlnsitsol.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryUser extends JpaRepository<User,Integer> {

    Optional<User> findByUserNameAndHoatDong(String s,boolean bl);
    List<User> findAllByHoatDong(boolean bl);
    List<User> getAllByUserNameLike(String bl);
    boolean existsByUserName(String s);

}
