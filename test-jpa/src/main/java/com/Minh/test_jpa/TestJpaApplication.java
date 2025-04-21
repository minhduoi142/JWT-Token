package com.Minh.test_jpa;

import com.Minh.test_jpa.dao.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TestJpaApplication.class, args);

		UserRepo repo = context.getBean(UserRepo.class);

//		List<Users> check = repo.findByusername("minh");
		System.out.println(repo.findAll());
//		Users users3 = context.getBean(Users.class);
//		users3.setId(3);
//		users3.setUsername("hoang");
//		users3.setPassword("12345");
//		Users users4 = context.getBean(Users.class);
//		users4.setId(4);
//        users4.setUsername("long");
//		users4.setPassword("12345");
//
//		repo.save(users3);
//		repo.save(users4);

	}

}
