package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.demo.model.OrderModel;


//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class Orderstatusupdate {
    private final OrderService orderService;
    @Autowired
    public Orderstatusupdate(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/updateorderstatus")
    public String updateorderstatus(@RequestBody OrderModel ordermodel) throws JsonProcessingException {
        System.out.println(ordermodel.toString());
        //int id=ordermodel.getIdorders();
        String name=ordermodel.getName();
        String order=ordermodel.getOrder();
        String time=ordermodel.getTime();
        //System.out.println(id +" "+ name);
        if(orderService.updateorderstatus(name,order,time)) {
            System.out.println("yes");
            return "1";
        }
        return "0";
    }
}
