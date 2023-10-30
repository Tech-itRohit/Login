package com.log.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.log.jwt.JwtTokenProvider;
//import com.log.model.User;
//import com.log.service.PasswordResetTokenService;

@RestController
//@RequestMapping("/token")
public class JwtController {



//   @Autowired
//   private UserDetailsService userDetailsService;
//   @Autowired
//  private User user;
// @Autowired
// private JwtTokenProvider jwtTokenProvider;

//  @PostMapping("/generate")
//  public ResponseEntity<?> generateToken(@RequestParam String email) {
//      UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//      String token = jwtTokenProvider.generateToken(userDetails);
//      return ResponseEntity.ok(token);
//  }
//  @Autowired
//  private PasswordResetTokenService tokenProvider;
//  @PostMapping("/generate")
//  public ResponseEntity<?> generateToken(@RequestParam String email) {
//      UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//      String token = tokenProvider.createToken(user);
//      return ResponseEntity.ok(token);
//  }
}
