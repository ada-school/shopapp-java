package org.adaschool.model;

import java.util.List;

public interface ShopService {
    void addProduct(Product product);

    boolean removeProduct(String name);

    Product findProduct(String name);

    void listProducts();

    void listProductsEmptyStock();

    void listProductsLowStock(int stockLevel);

    List<Product> findProductsByName(String name);

    int getProductCount();
}
