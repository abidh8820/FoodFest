package com.example.demo.model;
import jakarta.persistence.*;
public class ItemModel {
    private String name;
    private String prodCount;
    private String price;
    private String image;
    public ItemModel(){}
    public ItemModel(String name, String prodcCount, String price, String image) {
        this.name = name;
        this.prodCount= prodCount;
        this.price = price;
        this.image=image;
    }
    public String getName() {
        return name;
    }
    public String getProdCount() {return prodCount;}
    public String getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProdCount(String prodCount) {
        this.prodCount = prodCount;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
