package com.example.demo;
import com.example.demo.model.OrderModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Orderscheck {
    private final OrderService orderService;
    public Orderscheck(OrderService orderService){
        this.orderService=orderService;
    }
    @GetMapping("/admincheckorders")
    public List<OrderModel> Orderscheck() throws JsonProcessingException {

        List<OrderModel> listToReturn= orderService.getAllOrders();//new List<OrderModel();
        return listToReturn;

//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM orders");
//            resultSet = psCheckUserExists.executeQuery();
//
//            while(resultSet.next()) {
//                OrderModel ordermodel= new OrderModel(resultSet.getString("name"),resultSet.getString("order"),resultSet.getString("total"));
//                listToReturn.add(ordermodel);
//            }
//
//            resultSet.close();
//            psCheckUserExists.close();
//            connection.close();
//
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            System.out.println("Already exists error");
//        }
//        return listToReturn;
    }
}
