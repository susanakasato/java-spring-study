package com.java_study.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_study.spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
