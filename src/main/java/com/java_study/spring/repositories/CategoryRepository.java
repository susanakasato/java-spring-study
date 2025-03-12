package com.java_study.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.java_study.spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
