package org.adaschool.presentation;// Menu.java

import org.adaschool.model.Product;
import org.adaschool.model.Shop;

import java.util.Scanner;

public class Menu {
    private Shop shop;
    private Scanner scanner;

    public Menu(Shop shop) {
        this.shop = shop;
        scanner = new Scanner(System.in);
    }

    public void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            handleUserChoice(choice);
        } while (choice != 5);
    }

    private void displayMenu() {

        System.out.println(
                "|                          /////////////\\\\\\\n" +
                        "|                        (((((((((((((   \\\\\\\n" +
                        "|                        ))) ~~      ~~   (((\n" +
                        "|                        ((( (*)     (*)  )))\n" +
                        "|                        )))     <        ((( \n" +
                        "|                        ((( '\\______/`   ))) \n" +
                        "|                        )))\\___________/((( \n" +
                        "|                               _) (_ \n" +
                        "|                               /\\_/\\");
        System.out.println("±------------------------------------±");
        System.out.println("|  Administrador My Tienda de Barrio |");
        System.out.println("±------------------------------------±");
        System.out.println("1. Agregar producto                  |");
        System.out.println("2. Eliminar producto                 |");
        System.out.println("3. Actualizar producto               |");
        System.out.println("4. Ver todos los productos           |");
        System.out.println("5. Salir                             |");
        System.out.println("0------------------------------------0");
        System.out.print("   Ingresa tu opción:    (1, 2, 3, 4, 5)  ");
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                listProducts();
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }
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
        shop.addProduct(product);
    }

    private void removeProduct() {
        System.out.print("Escribe el nombre del producto: ");
        String name = scanner.nextLine();
        if (shop.removeProduct(name)) {
            System.out.println("Producto " + name + " fué eliminado");
        } else {
            System.out.println("No se econtró el producto con nombre " + name);
        }
    }

    private void updateProduct() {
        System.out.print("Escribe el nombre del producto: ");
        String name = scanner.nextLine();
        Product product = shop.findProduct(name);

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
        if (shop.getProductCount() > 0) {
            shop.listProducts();
        } else {
            System.out.println("No hay productos en la tienda.");
        }

    }
}
