package sell.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sell.project.demo.enity.Order;
import sell.project.demo.enity.Products;
import sell.project.demo.enity.User;

@Repository
public interface OrderReponsitory extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);

    List<Order> findByProducts(Products products);

    Optional<Order> findById(int id);

}
