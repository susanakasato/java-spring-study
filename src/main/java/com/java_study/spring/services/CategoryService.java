package com.java_study.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_study.spring.entities.Category;
import com.java_study.spring.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		return optionalCategory.orElseThrow();
	}
	
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category update(Long id, Category category) {
		Category categoryEntity = categoryRepository.getReferenceById(id);
		categoryEntity.setName(category.getName());
		return categoryRepository.save(categoryEntity);
	}
	
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}

