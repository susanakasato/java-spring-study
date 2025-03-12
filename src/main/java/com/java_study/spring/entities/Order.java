package com.java_study.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.java_study.spring.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	@ManyToOne()
	@JoinColumn(name = "client_id")
	private User client;
	
	private Integer orderStatus;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public Order() {}
	
	public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public void setClient(User client) {
		this.client = client;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
	}
	
	public Long getId() {
		return id;
	}
	
	public Instant getMoment() {
		return moment;
	}
	
	public User getClient() {
		return client;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(this.orderStatus);
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Double getTotal() {
		return items.stream().map(orderItem -> orderItem.getSubTotal()).reduce((a, b) -> a + b).get();
	}
	
	@Override
	public String toString() {
		return String.format("Order #%d - Moment: $s", getId(), getMoment().toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}
