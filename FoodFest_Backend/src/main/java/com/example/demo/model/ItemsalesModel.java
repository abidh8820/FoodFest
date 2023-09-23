package com.example.demo.model;

import jakarta.persistence.*;
@Entity(name = "items")
public class ItemsalesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`iditems`")
    private int iditems;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`quantity`")
    private int quantity;

    public ItemsalesModel(){}
    public ItemsalesModel(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
