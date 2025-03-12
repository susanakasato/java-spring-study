package com.java_study.spring.config;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java_study.spring.entities.Category;
import com.java_study.spring.entities.Order;
import com.java_study.spring.entities.Product;
import com.java_study.spring.entities.User;
import com.java_study.spring.entities.enums.OrderStatus;
import com.java_study.spring.repositories.CategoryRepository;
import com.java_study.spring.repositories.OrderRepository;
import com.java_study.spring.repositories.ProductRepository;
import com.java_study.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Mary", "mary@gmail.com", "99999-9999", "1234");
		User user2 = new User(null, "John", "john@gmail.com", "98888-8888", "0000");
		userRepository.saveAll(List.of(user1, user2));
		
		Order order1 = new Order(null, Instant.parse("2025-03-01T03:15:00Z"), user1, OrderStatus.SHIPPED);
		Order order2 = new Order(null, Instant.parse("2025-03-11T22:00:00Z"), user2, OrderStatus.PAID);
		Order order3 = new Order(null, Instant.parse("2025-03-12T12:20:20Z"), user2, OrderStatus.WAITING_PAYMENT);
		orderRepository.saveAll(List.of(order1, order2, order3));
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		categoryRepository.saveAll(List.of(category1, category2, category3));
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5);
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0);
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0);
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0);
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99);
		productRepository.saveAll(List.of(product1, product2, product3, product4, product5));

	}

}
