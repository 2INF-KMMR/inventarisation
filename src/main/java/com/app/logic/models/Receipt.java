package com.app.logic.models;

import com.app.logic.Receipts;
import com.app.logic.utils.Loader;

import java.util.Map;
import java.util.List;

public class Receipt {
    public int getId() {
        return id;
    }

    private static int _id = 1;
    private final int id;
    public Map<String, Double> productList;

    public Receipt(Map<String, Double> productList, Receipts receipts) {
        id = _id++;
        this.productList = productList;
        receipts.receiptsMap.put(id, this);
    }

    @Override
    public String toString() {
        double totalCost = .0;
        StringBuilder text = new StringBuilder("Receipt id:"+id+"\n\n");
        for (var entry : productList.entrySet()) {
            String productName = entry.getKey();
            double quantity = entry.getValue();
            double pricePerUnit = getPricePerUnit(productName);
            double productCost = quantity * pricePerUnit;
            text.append(String.format("%s - %.1f units - %.2f zł%n", productName, quantity, productCost));
            totalCost += productCost;
        }
        text.append(String.format("Total: %.2f zł%n", totalCost));
        return text.toString();
    }

    private double getPricePerUnit(String productName) {

        List<Product> products = Loader.loadProductList("Products.txt");

        for (Product product : products)
            if (product.getName().equals(productName))
                return product.getPrice();
        return .0;
    }
}