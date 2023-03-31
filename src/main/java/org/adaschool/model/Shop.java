package org.adaschool.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(String name) {
        return products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    public Product findProduct(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void listProducts() {
        products.forEach(System.out::println);
    }

    public int getProductCount() {
        return products.size();
    }

}