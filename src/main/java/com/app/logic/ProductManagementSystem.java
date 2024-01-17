package com.app.logic;

import com.app.logic.models.Customer;
import com.app.logic.utils.Generator;

import java.util.ArrayList;

public class ProductManagementSystem {
    static Generator generator = new Generator();
    public static ArrayList<Customer> customers = generator.generateCustomers(10);
    public static void start(){
        generator.generateMockData();
    }
    static public Receipts receipts = Receipts.instance;
    static public Shop shop = new Shop();
}
