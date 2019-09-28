package com.pisl.lab2.entity;

public enum  ComputerName {
    LENOVO("/img/lenovo.png"),
    MAC("/img/mac.jpg"),
    HP("/img/hp.jpg"),
    ASUS("/img/asus.jpg");

    String img;

    ComputerName(String img) {
        this.img = img;
    }

    public String getImg() {
        return this.img;
    }
}
