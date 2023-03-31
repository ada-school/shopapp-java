package org.adaschool.presentation;// Menu.java

import org.adaschool.model.Product;
import org.adaschool.model.ShopService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final ShopService shopService;
    private final Scanner scanner;

    public Menu(ShopService shopService) {
        this.shopService = shopService;
        scanner = new Scanner(System.in);
    }

    public void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            handleUserChoice(choice);
        } while (choice != 8);
    }

    private void displayMenu() {

        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Mostrar productos agotados            |");
        System.out.println("6. Mostrar productos con inventario bajo |");
        System.out.println("7. Buscar producto por nombre            |");
        System.out.println("8. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 8)  ");
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> {
                listProducts();
                enterPause();
            }
            case 5 -> {
                showEmptyStockProducts();
                enterPause();
            }
            case 6 -> {
                showLowInventoryProducts();
                enterPause();
            }
            case 7 -> {
                findProductByName();
                enterPause();
            }
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }

    }

    private void findProductByName() {
        System.out.print("Ingresa el nombre del producto: ");
        String name = scanner.nextLine();
        List<Product> productsByName = shopService.findProductsByName(name);
        if (productsByName.isEmpty()) {
            System.out.println("No se encontraron productos con el nombre " + name);
        } else {
            System.out.println(productsByName);
        }
    }

    private void showLowInventoryProducts() {
        System.out.print("Ingresa el umbral de inventario bajo: ");
        int threshold = scanner.nextInt();
        shopService.findLowInventoryProducts(threshold);
    }

    private void showEmptyStockProducts() {
        shopService.listProductsEmptyStock();
    }

    private void enterPause() {
        System.out.println("Presiona Enter para continuar");
        scanner.nextLine();
    }

    private void addProduct() {
        System.out.print("Escribe el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Escribe el precio del producto: ");
        double price = scanner.nextDouble();
        System.out.print("Escribe la cantidad de unidades disponibles de inventario: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = new Product(name, price, stock);
        shopService.addProduct(product);
    }

    private void removeProduct() {
        System.out.print("Escribe el nombre del producto: ");
        String name = scanner.nextLine();
        if (shopService.removeProduct(name)) {
            System.out.println("Producto " + name + " fué eliminado");
        } else {
            System.out.println("No se econtró el producto con nombre " + name);
        }
    }

    private void updateProduct() {
        System.out.print("Escribe el nombre del producto: ");
        String name = scanner.nextLine();
        Product product = shopService.findProduct(name);

        if (product != null) {
            System.out.print("Escribe el nuevo precio (actual: " + product.getPrice() + "): ");
            double price = scanner.nextDouble();
            System.out.print("Escribe la cantidad de unidades del inventario (actual: " + product.getStock() + "): ");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            product.setPrice(price);
            product.setStock(stock);
        } else {
            System.out.println("Producto con nombre " + name + " no encontrado.");
        }
    }

    private void listProducts() {
        if (shopService.getProductCount() > 0) {
            shopService.listProducts();
        } else {
            System.out.println("No hay productos en la tienda.");
        }

    }
}
