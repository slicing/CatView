package com.slicing.springbootdemo.bean;

public class Product {
    private String name;
    private int id;
    private double count;

    public Product() {
    }

    public Product(String name, int id, double count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
