//package com.qlnsitsol.demo.Controller;
//
//import com.qlnsitsol.demo.DTO.TokenDto;
//import com.qlnsitsol.demo.Service.RoleService;
//import com.qlnsitsol.demo.Service.UserService;
//import com.qlnsitsol.demo.jwt.JwtProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.social.facebook.api.impl.FacebookTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/oauth")
//@CrossOrigin
//public class OauthController {
//    @Value("${google.clientId}")
//    String googleClientId;
//
//    @Value("${secretPsw}")
//    String secretPsw;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    JwtProvider jwtProvider;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    RoleService roleService;
//
//    @PostMapping("/google")
//    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException, IOException {
//        final NetHttpTransport transport = new NetHttpTransport();
//        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
//        GoogleIdTokenVerifier.Builder verifier =
//                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
//                        .setAudience(Collections.singletonList(googleClientId));
//        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
//        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
//        User user = new User();
//        if(userService.existsByEmail(payload.getEmail()))
//            user = userService.getByEmail(payload.getEmail()).get();
//        else
//            user = saveUser(payload.getEmail());
//        TokenDto tokenRes = login(user);
//        return new ResponseEntity(tokenRes, HttpStatus.OK);
//    }
//    @PostMapping("/facebook")
//    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
//        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
//        final String [] fields = {"email", "picture"};
//        org.springframework.social.facebook.api.User  user =facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
//        User user1 = new User();
//        if(userService.existsByEmail(user.getEmail()))
//            user1 = userService.getByEmail(user.getEmail()).get();
//        else
//            user1 = saveUser(user.getEmail());
//        TokenDto tokenRes = login(user1);
//        return new ResponseEntity(tokenRes, HttpStatus.OK);
//    }
////    private TokenDto login2(User  user){
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(user.getEmail(), secretPsw)
////        );
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////        String jwt = jwtProvider.generateToken(authentication);
////        TokenDto tokenDto = new TokenDto();
////        tokenDto.setValue(jwt);
////        return tokenDto;
////    }
//    private TokenDto login(User  user){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getEmail(), secretPsw)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtProvider.generateToken(authentication);
//        TokenDto tokenDto = new TokenDto();
//        tokenDto.setValue(jwt);
//        return tokenDto;
//    }
//
//    private User saveUser(String email){
//        User user = new User(email, passwordEncoder.encode(secretPsw));
//        Role roleUser = roleService.getByRoleName(RoleName.ROLE_USER.ROLE_USER).get();
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleUser);
//        user.setRoles(roles);
//        return userService.save(user);
//    }
//
//}
