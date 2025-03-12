package com.java_study.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_study.spring.entities.OrderItem;
import com.java_study.spring.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
