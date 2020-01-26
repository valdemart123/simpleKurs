package com.valentyn.menu;

import com.valentyn.discount.DiscountOperations;
import com.valentyn.product.BaseProduct;
import com.valentyn.product.ListOfProducts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainMenu {

    Scanner sc = new Scanner(System.in);
    ListOfProducts allProducts = new ListOfProducts();
    HashMap<Integer, BaseProduct> listProducts = allProducts.getProductsAssortment();
    Set<Map.Entry<Integer, BaseProduct>> set = listProducts.entrySet();
    DiscountOperations discount = new DiscountOperations();
    int discountValue;

    public void startProgram() {
        System.out.println("Вы в системе МАГАЗИН.\nНиже вы можете увидеть список наших товаров и их цену.");
        showProducts();
    }

    public void showProducts() {
        for (Map.Entry<Integer, BaseProduct> me : set) {
            System.out.print(me.getKey() + ": ");
            me.getValue().showProduct();
            System.out.println("\n");
        }

        System.out.println("Пожалуйста сделайте свой выбор и введите ID");
        int id = Integer.valueOf(sc.nextLine());
        System.out.println("Пожалуйста введите количество");
        int qt = Integer.valueOf(sc.nextLine());
        System.out.println("Есть ли у вас Скидка? (False - Нет, True - Да)");
        boolean existVoucher = Boolean.valueOf(sc.nextLine());
        if (existVoucher == true) {
            System.out.println("Введите код ваучера");
            String code = sc.nextLine();
            discountValue = discount.checkDiscountExist(code);
        } else {
            discountValue = 0;
        }
        order(id, qt, discountValue);
        selectOption(id);
    }

    public void selectOption(int id) {
        System.out.println("Введите Еще что бы купить еще товар\n Введите Выход что бы выйти.");
        String operationValue = sc.nextLine();
        switch (operationValue) {
            case "Еще":
                showProducts();
                break;
            case "Выход":
                System.exit(0);
                break;
        }
    }

    public void order(int id, int qt, int discount) {
        listProducts.get(id).makeOrder(qt, discount);
    }
}
