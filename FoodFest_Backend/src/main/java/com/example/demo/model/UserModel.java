package com.example.demo.model;

import jakarta.persistence.*;

@Entity(name = "user")
public class UserModel {
    @Id
    private String name;
    private String password;
    private String email;

    public UserModel(){}
    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public UserModel(String name, String password, String email) {
        this.name = name;
        this.password= password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
