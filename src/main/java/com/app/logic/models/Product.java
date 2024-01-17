package com.app.logic.models;

public class Product {

    private final int id;
    private String name;
    private double price;
    private boolean byWeight;

    public Product(int id, String name, double price, boolean byWeight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.byWeight = byWeight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWeighted() {
        return byWeight;
    }

    private void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }

}



