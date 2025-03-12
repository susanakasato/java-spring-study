package com.java_study.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_study.spring.entities.User;
import com.java_study.spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User update(Long id, User user) {
		User entityUser = userRepository.getReferenceById(id);
		entityUser.setName(user.getName());
		entityUser.setEmail(user.getEmail());
		entityUser.setPhone(user.getPhone());
		entityUser.setPassword(user.getPassword());
		return userRepository.save(entityUser);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
