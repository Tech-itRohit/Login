package com.log.controller;

import com.log.jwt.JwtTokenHelper;
import com.log.model.JwtRequest;
import com.log.model.JwtResponse;
//import com.log.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.web.bind.annotation.ExceptionHandler;




//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
//@Tag(name="AuthController", description= "APIs for Authentification")
public class JwtAuthenticationController 
{
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtTokenHelper jwtTokenhelper;

    //private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
//    @Autowired
//    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest request) 
    {
        System.out.println("stativvvvvvvvv");
        this.doAuthenticate(request.getUsername(), request.getPassword());
        System.out.println("aaaaaaaaaaaa");

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenhelper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
							              .jwtToken(token)
							              .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) 
    {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try 
        {
            manager.authenticate(authentication);
        } 
        catch (BadCredentialsException e)
        {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
//    @PostMapping("/create-user") 
//    public com.log.entity.User createuser(@RequestBody com.log.entity.User user) 
//    {
//    	return userService.createUser(user);
//    }
}

