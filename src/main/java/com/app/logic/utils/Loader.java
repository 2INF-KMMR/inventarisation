package com.app.logic.utils;

import com.app.logic.models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loader {
    static private List<Product> products = new ArrayList<>();
    static private Map<String, Double> priceList = new HashMap<>();

    static public List<Product> loadProductList(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String priceString = parts[2].replace(',', '.');
                double price = Double.parseDouble(priceString);
                boolean byWeigth = Boolean.parseBoolean(parts[3].trim());
                Product product = new Product(id, name, price, byWeigth);
                products.add(product);
            }
            for (Product p : products) {
                Double currentValue = priceList.get(p.getName());
                if (currentValue == null) {
                    priceList.put(p.getName(), 1.0);
                } else {
                    priceList.put(p.getName(), currentValue + 1.0);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

