package com.qlnsitsol.demo.Controller;
import com.qlnsitsol.demo.DTO.JwtDto;
import com.qlnsitsol.demo.DTO.LoginUser;
import com.qlnsitsol.demo.DTO.Message;
import com.qlnsitsol.demo.DTO.UserDTO;
import com.qlnsitsol.demo.Service.NhanVienService;
import com.qlnsitsol.demo.Service.RoleService;
import com.qlnsitsol.demo.Service.UserService;
import com.qlnsitsol.demo.entity.NhanVien;
import com.qlnsitsol.demo.entity.Role;
import com.qlnsitsol.demo.entity.User;
import com.qlnsitsol.demo.enums.RoleName;
import com.qlnsitsol.demo.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    NhanVienService nhanVienService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Không được để trống"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUserName(userDTO.getUserName()))
            return new ResponseEntity(new Message("tên đó đã tồn tại"), HttpStatus.BAD_REQUEST);
        NhanVien nv = nhanVienService.getOne(userDTO.getNhanvienid()).get();
        User user =
                new User(userDTO.getUserName(),
                        passwordEncoder.encode(userDTO.getPassword()));
        Set<Role> roles = new HashSet<>();
       if (userDTO.getRole().equals("")){
           roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
       }
        if(userDTO.getRole().equals("2"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        if(userDTO.getRole().equals("1"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_MANAGER).get());
        user.setRoles(roles);
        user.setNhanVien(nv);
        user.setHoatDong(true);
        nv.setUser(user);
        userService.save(user);
        nhanVienService.save(nv);
        return new ResponseEntity(new Message("Tao thanh cong"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("badly placed fields"), HttpStatus.BAD_REQUEST);
       User user =  userService.getByUserName(loginUser.getUserName()).get();
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));// kiem tra user va password
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Trả về jwt cho người dùng.
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),user.getNhanVien().getId(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
