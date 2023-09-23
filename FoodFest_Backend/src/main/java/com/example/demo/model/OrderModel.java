package com.example.demo.model;

import jakarta.persistence.*;

@Entity(name = "orders")
public class OrderModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idorders`")
    private int idorders;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`order`")
    private String order;
    @Column(name = "`total`")
    private String total;
    @Column(name = "`time`")
    private String time;
    @Column(name = "`status`")
    private String status;

    public OrderModel(){}
    public OrderModel(String name, String order, String total) {
        this.name = name;
        this.order = order;
        this.total = total;
        this.status = "not delivered";
    }

    // Getter methods
    public int getIdorders() {
        //System.out.println(idorders);
        return idorders;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public String getTotal() {
        return total;
    }
    public String getTime() {
        return time;
    }
    public String getStatus() {
        return status;
    }

    // Setter methods
    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "field1='" + idorders + '\'' +
                ", field2='" + name + '\'' +
                ", field3='" + order + '\'' +
                ", field4='" + time + '\'' +
                ", field5='" + status + '\'' +
                // Include other fields here
                '}';
    }
}
