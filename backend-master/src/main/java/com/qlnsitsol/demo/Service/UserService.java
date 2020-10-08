package com.qlnsitsol.demo.Service;

import com.qlnsitsol.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

     Optional<User> getByUserName(String s);
     List<User> getlist();
     List<User> USERS (boolean bl);
    List<User> timkiem (String bl);
     Optional<User> getone (int id);

    boolean existsByUserName(String s);

      User save(User user);
}
