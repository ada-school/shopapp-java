package org.adaschool.model;

import java.util.ArrayList;
import java.util.List;

public class Shop implements ShopService {
    private List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean removeProduct(String name) {
        return products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    @Override
    public Product findProduct(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void listProducts() {
        products.forEach(System.out::println);
    }

    @Override
    public void listProductsEmptyStock() {
        //TODO: Implement this method
        System.out.println("Implement this method");
    }

    @Override
    public List<Product> findLowInventoryProducts(int threshold) {
        //TODO: Implement this method
        System.out.println("Implement this method");
        return null;
    }

    @Override
    public List<Product> findProductsByName(String name) {
        //TODO: Implement this method
        System.out.println("Implement this method");

        return null;
    }

    @Override
    public int getProductCount() {
        return products.size();
    }

}