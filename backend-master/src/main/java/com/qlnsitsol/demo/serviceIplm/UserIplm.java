package com.qlnsitsol.demo.serviceIplm;

import com.qlnsitsol.demo.Service.UserService;
import com.qlnsitsol.demo.entity.User;
import com.qlnsitsol.demo.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserIplm implements UserService {
    @Autowired
    RepositoryUser repositoryUser;

    @Override
    public Optional<User> getByUserName(String s) {
        return repositoryUser.findByUserNameAndHoatDong(s,true);
    }

    @Override
    public List<User> getlist() {
        return repositoryUser.findAll();
    }

    @Override
    public List<User> USERS(boolean bl) {
        return repositoryUser.findAllByHoatDong(bl);
    }

    @Override
    public List<User> timkiem(String bl) {
        return repositoryUser.getAllByUserNameLike("%"+bl+"%");
    }

    @Override
    public Optional<User> getone(int id) {
        return repositoryUser.findById(id);
    }


    @Override
    public boolean existsByUserName(String s) {
        return repositoryUser.existsByUserName(s);
    }



    @Override
    public User save(User user) {
        return repositoryUser.save(user);
    }
}
