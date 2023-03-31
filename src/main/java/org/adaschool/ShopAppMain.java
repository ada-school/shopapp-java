package org.adaschool;

import org.adaschool.model.Shop;
import org.adaschool.presentation.Menu;

public class ShopAppMain {
    // Main.java
    public static void main(String[] args) {
        Shop shop = new Shop();
        Menu menu = new Menu(shop);
        menu.runMenu();
    }

}