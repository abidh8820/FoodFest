package com.example.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.demo.model.ItemModel;
import com.example.demo.model.OrderModel;

import java.util.Arrays;
import java.util.List;


//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController

public class Orders {

    private final OrderService orderService;
    private final ItemsalesService itemsalesService;
    @Autowired
    public Orders(OrderService orderService, ItemsalesService itemsalesService) {
        this.orderService = orderService;
        this.itemsalesService = itemsalesService;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> giveorder(@RequestBody OrderModel ordermodel) throws JsonProcessingException {
        String name=ordermodel.getName();
        String order=ordermodel.getOrder();
        String total=ordermodel.getTotal();
        String time=ordermodel.getTime();

        int giveordercheck=1;
        int eachitemorderincreasecheck=1;
//        if (orderService.giveOrder(name, order,total)) {
//            giveordercheck=1;
//        }
//        else {
//            giveordercheck=0;
//        }
        orderService.giveOrder(name, order,total, time);

        //json string to object using ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        ItemModel[] itemModels = objectMapper.readValue(order, ItemModel[].class);
        List<ItemModel> itemList = Arrays.asList(itemModels);

        for (ItemModel item : itemList) {

            if (itemsalesService.eachItemIncrease(item.getName(),item.getProdCount())) {
                //
            }
            else {
                eachitemorderincreasecheck= 0;
            }

        }

        if(giveordercheck * eachitemorderincreasecheck == 1){
            return new ResponseEntity<>("1", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("0", HttpStatus.UNAUTHORIZED);
        }

    }

//    public int checkOrderCred(String name,String order,String total)
//    {
//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//
//            psInsert = connection.prepareStatement("INSERT INTO orders(`name`,`order`,`total`) VALUES(?,?,?)");
//            psInsert.setString(1, name);
//            psInsert.setString(2, order);
//            psInsert.setString(3, total);
//            psInsert.executeUpdate();
//            System.out.println("order data saved");
//
//
//            //json string to object using ObjectMapper
//            ObjectMapper objectMapper = new ObjectMapper();
//            ItemModel[] itemModels = objectMapper.readValue(order, ItemModel[].class);
//            List<ItemModel> itemList = Arrays.asList(itemModels);
//
//            //System.out.println("tafsir ");
//            for (ItemModel item : itemList) {
//                //System.out.println(item.getName() + " "+ item.getProdCount());
//                try {
//                    Class.forName("com.mysql.jdbc.Driver");
//                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//                    PreparedStatement psCheckIfExists = connection.prepareStatement("SELECT * FROM items WHERE name = ?");
//                    psCheckIfExists.setString(1, item.getName());
//                    ResultSet rs = psCheckIfExists.executeQuery();
//
//                    if (rs.next()) {
//                        // Record exists, update it
//                        PreparedStatement psUpdate = connection.prepareStatement("UPDATE items SET quantity =quantity + ? WHERE name = ?");
//                        psUpdate.setInt(1, Integer.parseInt(item.getProdCount()));
//                        psUpdate.setString(2, item.getName());
//                        psUpdate.executeUpdate();
//                    } else {
//                        // Record doesn't exist, insert it
//                        PreparedStatement psInsertt = connection.prepareStatement("INSERT INTO items(`name`,`quantity`) VALUES(?,?)");
//                        psInsertt.setString(1, item.getName());
//                        psInsertt.setInt(2, Integer.parseInt(item.getProdCount()));
//                        psInsertt.executeUpdate();
//                    }
//
//                }
//                catch (Exception e) {
//                    System.out.println(e);
//                    return 0;
//                }
//            }
//
//            return 1;
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            System.out.println("Already exists error");
//        }
//        return 0;
//    }
}
