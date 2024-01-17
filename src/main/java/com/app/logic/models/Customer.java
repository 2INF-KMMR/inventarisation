package com.app.logic.models;

import java.util.Map;

public class Customer {
    private double money;
    public Receipt receipt;

    public Customer(int money, Receipt receipt) {
        this.money = money;
        this.receipt = receipt;
    }

    public Map<String, Double> getProductList() {
        return receipt.productList;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Customer's money: " + money + "\nCustomer's receipt:\n" + receipt;
    }
}
