package com.app.logic;

import com.app.logic.utils.Generator;
import com.app.logic.utils.Loader;

public class Test {
    static Generator generator = new Generator();
    public static void main(String[] args) {
//        var filePath = "products.txt";
//        generator.generateProductsFile(filePath);
//        var products = Loader.loadProductList(filePath);
//        for (var x : products)
//            System.out.println(x);
//
//        var priceList = generator.generateShopList();
//        for (var entry : priceList.entrySet())
//            System.out.println(entry.getKey()+"\n"+entry.getValue()+"\n");

        var customers = generator.generateCustomers(3);
        for (var x : customers)
            System.out.println(x);
    }
}