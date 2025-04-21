package com.Minh.test_jpa.service;

import com.Minh.test_jpa.dao.UserRepo;
import com.Minh.test_jpa.model.Users;
import com.Minh.test_jpa.model.UserPrincipal; // <-- import đúng
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repo.findByUsername(username);

        if (users == null) {
            System.out.println("Errors 404");
            throw new UsernameNotFoundException("404");
        }

        return new UserPrincipal(users); // SỬA Ở ĐÂY
    }
}
