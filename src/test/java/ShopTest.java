import org.adaschool.model.ArrayListShopService;
import org.adaschool.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    private ArrayListShopService shop;

    @BeforeEach
    void setUp() {
        shop = new ArrayListShopService();
    }

    @Test
    void testAddProduct() {
        Product product = new Product("TestProduct", 10.0, 5);
        shop.addProduct(product);
        Product foundProduct = shop.findProduct("TestProduct");
        assertNotNull(foundProduct);
        assertEquals(product, foundProduct);
    }

    @Test
    void testRemoveProduct() {
        Product product = new Product("TestProduct", 10.0, 5);
        shop.addProduct(product);
        boolean removed = shop.removeProduct("TestProduct");
        assertTrue(removed);
        Product foundProduct = shop.findProduct("TestProduct");
        assertNull(foundProduct);
    }

    @Test
    void testRemoveNonExistingProduct() {
        boolean removed = shop.removeProduct("NonExistingProduct");
        assertFalse(removed);
    }

    @Test
    void testFindProduct() {
        Product product = new Product("TestProduct", 10.0, 5);
        shop.addProduct(product);
        Product foundProduct = shop.findProduct("TestProduct");
        assertNotNull(foundProduct);
        assertEquals(product, foundProduct);
    }

    @Test
    void testFindNonExistingProduct() {
        Product foundProduct = shop.findProduct("NonExistingProduct");
        assertNull(foundProduct);
    }

    @Test
    void testFindLowInventoryProducts() {
        Product product1 = new Product("Product1", 10.0, 5);
        Product product2 = new Product("Product2", 15.0, 2);
        Product product3 = new Product("Product3", 20.0, 8);

        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        List<Product> lowInventoryProducts = shop.findLowInventoryProducts(3);
        assertEquals(1, lowInventoryProducts.size());
        assertEquals(product2, lowInventoryProducts.get(0));
    }

    @Test
    void testFindProductsByName() {
        Product product1 = new Product("Apple", 1.0, 10);
        Product product2 = new Product("Orange", 0.5, 20);
        Product product3 = new Product("Pineapple", 2.0, 5);

        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        List<Product> foundProducts = shop.findProductsByName("appl");
        assertEquals(2, foundProducts.size());
        assertEquals(product1, foundProducts.get(0));
        assertEquals(product3, foundProducts.get(1));
    }

}