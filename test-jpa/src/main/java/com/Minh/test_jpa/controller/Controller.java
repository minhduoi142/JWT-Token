package com.Minh.test_jpa.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
        @GetMapping("hello")
        public String greet()
        {return "HEllO" ;
        };
}
