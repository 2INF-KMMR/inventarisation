package com.app.logic;

import com.app.logic.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();
    private List<Product> soldProducts = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }

    public void sellOutProduct(Product soldProduct) {
        try {
            soldProducts.add(soldProduct);
            products.remove(soldProduct);
        } catch (Exception e) {
            System.out.println("Błąd przy sprzedawaniu produktu");
        }
    }


    public void log(int count) {
        System.out.println("Products in shop:");
        int displayCount = Math.min(count, products.size());
        for (int i = 0; i < displayCount; i++) {
            System.out.println(products.get(i));
        }
    }
}
