package com.app.logic;

import com.app.logic.Exceptions.FileReadWriteException;
import com.app.logic.models.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

public class Report {
    Shop shop = ProductManagementSystem.shop;
    public String productsReport() {
        String text = "";
        for (Product product : shop.getProducts()) {
            text+=product;
        }
        return text;
    }
    public String soldProductsReport() {
        String text = "";
        for (Product soldProduct : shop.getSoldProducts()) {
            text+=soldProduct;
        }
        return text;
    }
    public String productAmountReport() {
        return "Produktów w sklepie: " + shop.getProducts().size();
    }
    public String soldProductAmountReport() {
        return "Sprzedanych produktów w sklepie: " + shop.getSoldProducts().size();
    }
    public String soldProductTypeAmountReport() {
        List<Product> soldInShop = shop.getSoldProducts();
        Set<Product> uniqueSoldProductTypes = new HashSet<>(soldInShop);
        return "Sprzedanych rodzajów produktów w sklepie: " + uniqueSoldProductTypes.size();
    }
    public String productTypeAmountReport() {
        List<Product> availableInShop = shop.getProducts();
        Set<Product> uniqueProductTypes = new HashSet<>(availableInShop);
        return "Rodzajów produktów w sklepie: " + uniqueProductTypes.size();
    }

    public void writeProductAmountReportToFile(String fileName) throws FileReadWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Produktów w sklepie: " + shop.getProducts().size());
        } catch (Exception e) {
            throw new FileReadWriteException("Błąd przy zapisywaniu writeProductAmountReportToFile do pliku!");
        }
    }
    public void writeSoldProductAmountReportToFile(String fileName) throws FileReadWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Sprzedanych produktów w sklepie: " + shop.getSoldProducts().size());
        } catch (Exception e) {
            throw new FileReadWriteException("Błąd przy zapisywaniu writeSoldProductAmountReportToFile do pliku!");
        }
    }

    public void writeSoldProductTypeAmountReportToFile(String fileName) throws FileReadWriteException {
        List<Product> soldInShop = shop.getSoldProducts();
        Set<Product> uniqueSoldProductTypes = new HashSet<>(soldInShop);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Sprzedanych rodzajów produktów w sklepie: " + uniqueSoldProductTypes.size());
        } catch (Exception e) {
            throw new FileReadWriteException("Błąd przy zapisywaniu writeSoldProductTypeAmountReportToFile do pliku!");
        }
    }

    public void writeProductTypeAmountReportToFile(String fileName) throws FileReadWriteException {
        List<Product> availableInShop = shop.getProducts();
        Set<Product> uniqueProductTypes = new HashSet<>(availableInShop);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Rodzajów produktów w sklepie: " + uniqueProductTypes.size());
        } catch (Exception e) {
            throw new FileReadWriteException("Błąd przy zapisywaniu writeProductTypeAmountReportToFile do pliku!");
        }
    }
}
