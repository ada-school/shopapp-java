package org.adaschool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListShopService implements ShopService {
    private final List<Product> products;

    public ArrayListShopService() {
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
        List<Product> emptyStockProducts = products.stream()
                .filter(product -> product.getStock() == 0)
                .toList();
        emptyStockProducts.forEach(System.out::println);
    }

    @Override
    public List<Product> findLowInventoryProducts(int threshold) {
        return products.stream()
                .filter(product -> product.getStock() <= threshold)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public int getProductCount() {
        return products.size();
    }

}