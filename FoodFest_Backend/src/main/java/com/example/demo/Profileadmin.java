package com.example.demo;

import com.example.demo.model.ItemsalesModel;
import com.example.demo.model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Profileadmin {
    private final ItemsalesService itemsalesService;
    @Autowired
    public Profileadmin(ItemsalesService itemsalesService) {
        this.itemsalesService = itemsalesService;
    }
    @GetMapping("/profileadmin")
    public List<ItemsalesModel> profile() throws JsonProcessingException {
        List<ItemsalesModel> listToReturn= itemsalesService.getAllEachitemSales();//new List<OrderModel();
        return listToReturn;

//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM items");
//            resultSet = psCheckUserExists.executeQuery();
//
//            //System.out.println(name);
//
//            ArrayList<ItemsalesModel> listToReturn= new ArrayList<ItemsalesModel>();
//
//            //json string to object using model class ItemModel
//            while(resultSet.next()) {
//                ItemsalesModel itemsellsmodel= new ItemsalesModel(resultSet.getString("name"),resultSet.getInt("quantity"));
//                listToReturn.add(itemsellsmodel);
//
//            }
//
//            resultSet.close();
//            psCheckUserExists.close();
//            connection.close();
//
//            return listToReturn;
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            ArrayList<ItemsalesModel> listToReturn= new ArrayList<ItemsalesModel>();
//            return listToReturn;
//        }
    }
}
