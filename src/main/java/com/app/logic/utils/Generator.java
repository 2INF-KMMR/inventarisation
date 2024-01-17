package com.app.logic.utils;

import com.app.logic.ProductManagementSystem;
import com.app.logic.Receipts;
import com.app.logic.models.Customer;
import com.app.logic.models.Product;
import com.app.logic.models.Receipt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Generator {
    private final int MAX_CUSTOMERSPRODUCTS = 10;
    private String filePath;
    private Map<String, Double> customersShopList = new HashMap<>();
    private List<String> weightProducts = List.of("Apple", "Ground beef", "Yellow cheese", "Tomatoes", "Walnuts", "Potatoes", "Carrots", "Spinach",
        "Grapes", "Salmon", "Broccoli", "Chicken thighs", "Bell peppers", "Cucumbers", "Almonds", "Onions", "Avocado", "Strawberries", "Tilapia fillets", "Lettuce");
    private List<String> countableProducts = List.of(
        "Eggs", "Bread loaves", "Plain yogurt", "Oat flakes", "Chicken breasts",
        "Milk cartons", "Orange juice", "Applesauce", "Sausages", "Butter", "Lettuce heads",
        "Pizza", "Toilet paper rolls", "Toothbrushes", "Shampoo bottles", "Toothpaste tubes",
        "Dish soap", "AA batteries", "Facial tissues"
    );
    private Random rand = new Random();
    public String currentPath = "";

    public void generateProductsFile(String filePath) {
        Random rand = new Random();
        currentPath = filePath;
        // Generator produktów w sklepie
        var products = generateProducts(100);
        //Zapisywanie do pliku produktów w sklepie
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                String line = String.format("%d;%s;%.2f;%b", product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.isWeighted());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Map<String, Double> generateShopList() {
        Random rand = new Random();
        for (int i = 0; i <= MAX_CUSTOMERSPRODUCTS; i++) {
            if (rand.nextInt(2) == 1) {
                customersShopList.put(
                    weightProducts.get(
                        rand.nextInt(weightProducts.size())
                    ),
                    rand.nextInt(1000) / 100.0
                );
            } else {
                customersShopList.put(
                    countableProducts.get(
                        rand.nextInt(
                            countableProducts.size())), (double) rand.nextInt(3) + 1);
            }
        }
        return customersShopList;
    }

    public ArrayList<Customer> generateCustomers(int amount) {
        var customers = new ArrayList<Customer>();
        for (int i = 0; i < amount; i++)
            customers.add(new Customer(
                rand.nextInt(100) + 50, new Receipt(generateShopList(), Receipts.instance)
            ));
        return customers;
    }

    public void generateReceipts(int amount) {
        for (int i = 0; i < amount; i++)
            new Receipt(generateShopList(), Receipts.instance);
    }

    public void generateMockData() {
        generateReceipts(10);
        ProductManagementSystem.shop.getProducts().addAll(
            generateProducts(100)
        );
    }

    private static <T> T getRandomChoice(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(array.length);

        return array[randomIndex];
    }

    public List<Product> generateProducts(int amount) {
        var products = new ArrayList<Product>();

        for (int i = 0; i < amount; i++) {
            if (rand.nextInt(2) == 1) {
                products.add(new Product(i + 1,
                    countableProducts.get(rand.nextInt(countableProducts.size())),
                    rand.nextDouble(15) + 1, false));
            } else {
                products.add(new Product(i + 1, weightProducts.get(rand.nextInt(weightProducts.size())),
                    rand.nextDouble(15) + 1, true));
            }
        }
        return products;
    }
}