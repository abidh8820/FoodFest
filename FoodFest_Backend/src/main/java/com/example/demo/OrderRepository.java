package com.example.demo;
import com.example.demo.model.OrderModel;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    // Additional methods for custom queries or operations can be defined here
    OrderModel findByName(String name);
    OrderModel findByIdorders(int idorders);
    OrderModel findByOrder(String order);
    OrderModel findByTime(String time);
    OrderModel findByNameAndTime(String name, String time);
    OrderModel findByNameAndOrderAndTime(String name, String order, String time);
    List<OrderModel> findAllByName(String name);
    List<OrderModel> findAllByOrder(String order);
    List<OrderModel> findAllByTime(String time);
    List<OrderModel> findAllByNameAndTime(String name, String time);
    List<OrderModel> findAllByNameAndOrderAndTime(String name, String order, String time);
}
