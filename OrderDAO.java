package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Order;

@Repository
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Order> getAllOrders() {
		return sessionFactory.openSession().createQuery("from Order", Order.class).list();
	}

	@Transactional
	public Order getOrderById(Long id) {
		return sessionFactory.openSession().get(Order.class, id);
	}

	@Transactional
	public void saveOrder(Order order) {
		sessionFactory.openSession().saveOrUpdate(order);
	}

	@Transactional
	public void deleteOrder(Long id) {
		Order order = getOrderById(id);
		if (order != null) {
			sessionFactory.openSession().delete(order);
		}
	}
}
