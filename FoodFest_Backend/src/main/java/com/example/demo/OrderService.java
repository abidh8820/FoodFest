package com.example.demo;
import com.example.demo.model.ItemsalesModel;
import com.example.demo.model.OrderModel;
import com.example.demo.model.UserModel;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void giveOrder(String name, String order, String total, String time) {
        // Create a new order entity
        OrderModel orders = new OrderModel();
        orders.setName(name);
        orders.setOrder(order);
        orders.setTotal(total);
        orders.setTime(time);
        orders.setStatus("not delivered");
        // Save the order entity to the database
        orderRepository.save(orders);
    }
    public boolean updateorderstatus(String name,String order, String time) {
        //System.out.println(name +" "+ order +" "+ time);
        //OrderModel orders = orderRepository.findByNameAndOrderAndTime(name, order, time);
        //OrderModel orders = orderRepository.findAllByName(name);
        //List<OrderModel>orders = orderRepository.findAllByName(name);
        //List<OrderModel>orders = orderRepository.findAllByTime(time);
        //List<OrderModel>orders = orderRepository.findAllByNameAndOrderAndTime(name, order, time);
        //OrderModel orders2 = orderRepository.findByTime(time);

        //List<OrderModel>orders = orderRepository.findAllByNameAndTime(name, time);
        OrderModel orders = orderRepository.findByNameAndTime(name,time);
        System.out.println(orders);
        if (orders != null ) {
            orders.setStatus("Delivered");
            orderRepository.save(orders);
            return true; // Update successful
        }
//        return false;
        return false;
    }
    public List<OrderModel> getAllOrders() {
        return (List<OrderModel>) orderRepository.findAll();
    }

    public List<OrderModel> getPersonalOrders(String name) {
//        List<OrderModel> orders = new ArrayList<>();
//        orders.add(orderRepository.findByName(name));
//        return orders;
        return orderRepository.findAllByName(name);

    }
}
