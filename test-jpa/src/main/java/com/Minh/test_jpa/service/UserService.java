
package com.Minh.test_jpa.service;

import com.Minh.test_jpa.dao.UserRepo;
import com.Minh.test_jpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    public void register(Users users)
    {
        repo.save(users);
    }
}