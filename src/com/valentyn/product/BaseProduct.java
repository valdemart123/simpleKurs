package com.valentyn.product;

import com.valentyn.orders.OrdersHistory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseProduct {
    private String productTitle;
    private int availableQuantity;
    private double price;
    OrdersHistory history = new OrdersHistory();

    public BaseProduct(String productTitle, int availableQuantity, double price) {
        this.productTitle = productTitle;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public void makeOrder(int ordered, int discount) {
        double totalPrice = new BigDecimal(price - (price * discount / 100)).setScale(2, RoundingMode.UP).doubleValue();
        if (availableQuantity < ordered) {
            System.out.println("Product out of stock for your quantity. You can order only: " + availableQuantity + "pts");
        } else {
            availableQuantity -= ordered;
            String historyString = String.valueOf("Вы заказали " + ordered + " штук " + productTitle + " за " + ordered * totalPrice + " евро");
            history.addEntityHistory(historyString);
            System.out.println(historyString);
        }
    }

    public void showProduct() {
        System.out.println(productTitle + " \n" + price + " \n" + availableQuantity + " ");
    }
}
