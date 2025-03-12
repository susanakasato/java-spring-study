package com.java_study.spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java_study.spring.entities.User;
import com.java_study.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Mary", "mary@gmail.com", "99999-9999", "1234");
		User user2 = new User(null, "John", "john@gmail.com", "98888-8888", "0000");
		userRepository.saveAll(List.of(user1, user2));
	}

}
