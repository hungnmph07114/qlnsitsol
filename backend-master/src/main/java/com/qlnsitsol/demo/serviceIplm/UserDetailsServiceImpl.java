package com.qlnsitsol.demo.serviceIplm;
import com.qlnsitsol.demo.DTO.MainUser;
import com.qlnsitsol.demo.Service.UserService;
import com.qlnsitsol.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = null;
        user = userService.getByUserName(s);
//        User user =  userService.getByEmail(s).orElseThrow(()-> new UsernameNotFoundException("Không tìm thấy email"));
        return MainUser.build(user.get());
    }
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userService.getByUserName(s).get();
//        return MainUser.build(user);
//    }
}
