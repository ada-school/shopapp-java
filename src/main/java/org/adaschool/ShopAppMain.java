package org.adaschool;

import org.adaschool.model.ArrayListShopService;
import org.adaschool.model.ShopService;
import org.adaschool.presentation.Menu;

public class ShopAppMain {
    // Main.java
    public static void main(String[] args) {
        ShopService shop = new ArrayListShopService();
        Menu menu = new Menu(shop);
        menu.runMenu();
    }

}