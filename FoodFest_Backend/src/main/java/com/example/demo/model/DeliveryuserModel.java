package com.example.demo.model;
import jakarta.persistence.*;

@Entity(name = "deliveryuser")
public class DeliveryuserModel {
    @Id
    private String name;
    private String password;

    public DeliveryuserModel(){}
    public DeliveryuserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public DeliveryuserModel(String name, String password, String email) {
        this.name = name;
        this.password= password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
