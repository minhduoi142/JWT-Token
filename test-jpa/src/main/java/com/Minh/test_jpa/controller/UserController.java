package com.Minh.test_jpa.controller;
import com.Minh.test_jpa.model.Users;
import com.Minh.test_jpa.service.JwtService;
import com.Minh.test_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @Autowired
    UserService service;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @PostMapping("register")
    public void register(@RequestBody Users users)
    {
        users.setPassword(encoder.encode(users.getPassword()));
        service.register(users);

    }

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService ;

    @PostMapping("login")
    public String login(@RequestBody Users users){
        Authentication authentication;
        authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
    if(authentication.isAuthenticated())
        return jwtService.generateToken(users.getUsername());
    else
        return "Failed";
    }


}
