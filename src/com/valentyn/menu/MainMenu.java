package com.valentyn.menu;

import com.valentyn.product.BaseProduct;
import com.valentyn.product.ListOfProducts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainMenu {
    Scanner sc= new Scanner(System.in);
    ListOfProducts allProducts = new ListOfProducts();
    HashMap<Integer, BaseProduct> listProducts = allProducts.getProductsAssortment();
    Set<Map.Entry<Integer, BaseProduct>> set = listProducts.entrySet();

    public void startProgram () {
        System.out.println("Вы в системе МАГАЗИН.\nНиже вы можете увидеть список наших товаров и их цену.");
        for (Map.Entry<Integer, BaseProduct> me : set) {
            System.out.print(me.getKey() + ": ");
            me.getValue().showProduct();
            System.out.println("\n");
        }

        System.out.println("Пожалуйста сделайте свой выбор и введите ID");
        int id = Integer.valueOf(sc.nextLine());
        System.out.println("Пожалуйста введите количество");
        int qt = Integer.valueOf(sc.nextLine());
        order(id, qt);
    }

    public void order(int id, int qt) {
        listProducts.get(id).makeOrder(qt);

    }
}
