package com.example.demo.model;

public class ProfileModel {
    private String idorders;
    private String total;

    public ProfileModel(){}
    public ProfileModel(String idorders, String total) {
        this.idorders = idorders;
        this.total = total;
    }

    public String getIdorders() {
        return idorders;
    }
    public String getTotal() {
        return total;
    }
    public void setIdorders(String idorders) {
        this.idorders = idorders;
    }
    public void setTotal(String total) {
        this.total = total;
    }

}
