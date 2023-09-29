/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package makeup2;

import java.util.ArrayList;

class Product {
    private final String productId;
    private final String name;
    private final double price;
    private int quantityInStock;

    public Product(String productId, String name, double price, int quantityInStock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getters and setters for properties

    public void updateQuantity(int quantity) {
        quantityInStock += quantity;
    }

    // Additional methods for product management

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class CosmeticsProduct extends Product {
    private final String colour;
    private final String type;

    public CosmeticsProduct(String productId, String name, double price, int quantityInStock, String color, String type) {
        super(productId, name, price, quantityInStock);
        this.colour = colour;
        this.type = type;
    }

    // Getters and setters for color and type

    // Additional methods specific to cosmetics products
}

class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String productId, int quantity) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.updateQuantity(quantity);
                return;
            }
        }
    }

    public void deleteProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
    }

    // Other inventory management methods
}

class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    // Getters for customer ID and name

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Sales {
    private ArrayList<Product> cart;

    public Sales() {
        cart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total = product.getPrice();
        }
        return total;
    }

    public void generateSalesReport(Customer customer) {
        System.out.println("Sales Report for Customer: " + customer.getName());
        System.out.println("------------------------------");
        for (Product product : cart) {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: R" + product.getPrice());
            System.out.println("------------------------------");
        }
        System.out.println("Total: R" + calculateTotal());
    }

    // Other sales-related methods
}

public class MakeUp2 {
    public static void main(String[] args) {
        // Create product objects and add them to the inventory

        // Create customer objects

        // Simulate customer transactions

        // Generate and display sales reports
    }
}