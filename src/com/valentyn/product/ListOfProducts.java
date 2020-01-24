package com.valentyn.product;

import java.util.HashMap;

public class ListOfProducts {

    int productId = 0;
    private HashMap <Integer, BaseProduct> productsAssortment = new HashMap<>();

    public void addProducts(String productTitle, int availableQuantity, double price) {
        productId++;
        BaseProduct product = new BaseProduct(productTitle, availableQuantity, price);
        productsAssortment.put(productId, product);
    }

    public HashMap<Integer, BaseProduct> getProductsAssortment() {
        return productsAssortment;
    }
}
