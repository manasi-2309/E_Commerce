package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDAO;
import com.model.Order;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
    }

    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }
}
