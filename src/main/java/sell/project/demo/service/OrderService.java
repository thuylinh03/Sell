package sell.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sell.project.demo.enity.Order;
import sell.project.demo.enity.Products;
import sell.project.demo.enity.User;
import sell.project.demo.repository.OrderReponsitory;

@Service
public class OrderService {
    @Autowired
    private OrderReponsitory orderReponsitory;

    public void saveOrder(Order order) {
        orderReponsitory.save(order);
    }

    public Order getOrderById(int id) {
        return orderReponsitory.findById(id).orElse(null);
    }

    public List<Order> getOrdersUser(User user) {
        return orderReponsitory.findByUser(user);
    }

    public List<Order> getOrderProducts(Products products) {
        return orderReponsitory.findByProducts(products);
    }

    public void saveOrUpdate(Order order) {
        orderReponsitory.save(order);
    }
}
