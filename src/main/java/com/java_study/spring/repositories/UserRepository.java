package com.java_study.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_study.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
