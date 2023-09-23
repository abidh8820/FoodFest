package com.example.demo;
import com.example.demo.model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")

@SpringBootApplication
@RestController

public class Profile {
    private final OrderService orderService;
    public Profile(OrderService orderService){
        this.orderService=orderService;
    }
    @PostMapping("/profile")
    public List<Integer> profile(@RequestBody Map<String, String> loginCredentials) throws JsonProcessingException {
        String name="";

        Iterator<Map.Entry<String, String>> itr = loginCredentials.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            if(entry.getKey()== "name"){
                name=entry.getValue();
                break;
            }
        }

        List<OrderModel> listToReturn= new ArrayList<>();
        List<Integer> listToReturn2= new ArrayList<>();
        listToReturn=orderService.getPersonalOrders(name);//new List<OrderModel();
        //System.out.println(listToReturn);
        int totalPrice=0;
        for (OrderModel orderiter : listToReturn) {
            listToReturn2.add(Integer.parseInt(orderiter.getTotal()));
        }
        //System.out.println(totalPrice);
        //return totalPrice;
        return listToReturn2;

//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psCheckUserExists = null;
//        ResultSet resultSet = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
//            psCheckUserExists = connection.prepareStatement("SELECT * FROM orders WHERE name = ?");
//            psCheckUserExists.setString(1, name);
//            resultSet = psCheckUserExists.executeQuery();
//
//            //System.out.println(name);
//
//            ArrayList<String> listToReturn= new ArrayList<String>();
//
//            while(resultSet.next()) {
//                String idorder = resultSet.getString("idorders");
//                String order = resultSet.getString("order");
//                String total = resultSet.getString("total");
//
//                //ProfileModel profilemodel=new ProfileModel(idorder, total);
//                listToReturn.add(total);
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
//            ArrayList<String> listToReturn= new ArrayList<String>();
//            return listToReturn;
//        }
    }

    /*public ArrayList<ProfileModel> profile(@RequestBody Map<String, String> loginCredentials) throws JsonProcessingException {
        String name="";

        Iterator<Map.Entry<String, String>> itr = loginCredentials.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            if(entry.getKey()== "name"){
                name=entry.getValue();
                break;
            }
        }

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krunch", "root", "Rubaiyat26");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM orders WHERE name = ?");
            psCheckUserExists.setString(1, name);
            resultSet = psCheckUserExists.executeQuery();

            //System.out.println(name);

            ArrayList<ProfileModel> listToReturn= new ArrayList<ProfileModel>();

            while(resultSet.next()) {
                String idorder = resultSet.getString("idorders");
                String order = resultSet.getString("order");
                String total = resultSet.getString("total");

                ProfileModel profilemodel=new ProfileModel(idorder, total);
                listToReturn.add(profilemodel);

            }

            resultSet.close();
            psCheckUserExists.close();
            connection.close();

            for(ProfileModel item : listToReturn) {
                System.out.println(item.getIdorders() +" "+ item.getTotal());
            }

            return listToReturn;

        }
        catch (Exception e) {
            System.out.println(e);
            ArrayList<ProfileModel> listToReturn= new ArrayList<ProfileModel>();
            return listToReturn;
        }

    }*/
}
