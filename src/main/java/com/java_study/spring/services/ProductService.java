package com.java_study.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_study.spring.entities.Product;
import com.java_study.spring.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.orElseThrow();
	}
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	public Product update(Long id, Product product) {
		Product productEntity = productRepository.getReferenceById(id);
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setPrice(product.getPrice());
		return productRepository.save(productEntity);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
}
