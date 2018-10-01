package com.example.demo.bean;

public class Product {
    private int id;
    private String name;
    private double count;

    public Product(int id, String name, double count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
