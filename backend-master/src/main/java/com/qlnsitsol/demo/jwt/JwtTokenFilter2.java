//package com.example.hoconline.jwt;
//
//import com.example.hoconline.service.iplm.UserDetailsServiceImpl2;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtTokenFilter2 extends OncePerRequestFilter {
//    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter2.class);
//
//    @Autowired
//    JwtProvider jwtProvider;
//
//    @Autowired
//    UserDetailsServiceImpl2 userDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
//        try {
//            String token = getToken(req);
//            String email = jwtProvider.getEmailFromToken(token);
//            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//            UsernamePasswordAuthenticationToken auth =
//                    new UsernamePasswordAuthenticationToken(email, null, userDetails.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }catch (Exception e){
//            logger.error("fail en el método doFilter");
//        }
//        chain.doFilter(req, res);
//    }
//
//    private String getToken(HttpServletRequest request){
//        String header = request.getHeader("Authorization");
//        if(header != null && header.startsWith("Bearer"))
//            return header.replace("Bearer ", "");
//        return null;
//    }
//}
