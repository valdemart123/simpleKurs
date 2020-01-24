package com.valentyn.menu;

import com.valentyn.product.BaseProduct;
import com.valentyn.product.ListOfProducts;

import java.util.HashMap;

public class MainMenu {
    public void startProgram () {
        ListOfProducts allProducts = new ListOfProducts();
        System.out.println("Вы в системе МАГАЗИН.\nНиже вы можете увидеть список наших товаров и их цену.");
        HashMap<Integer, BaseProduct> products = allProducts.getProductsAssortment();
        
    }
}
