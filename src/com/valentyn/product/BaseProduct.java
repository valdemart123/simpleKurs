package com.valentyn.product;



public class BaseProduct {
    private String productTitle;
    private int availableQuantity;
    private double price;

    public BaseProduct(String productTitle, int availableQuantity, double price) {
        this.productTitle=productTitle;
        this.availableQuantity=availableQuantity;
        this.price=price;
    }

    public int getProductQuantity() {
        return availableQuantity;
    }

    public void makeOrder(int ordered) {
        if (availableQuantity<ordered) {
            System.out.println("Product out of stock for your quantity. You can order only: "+ availableQuantity + "pts");
        } else {
            availableQuantity -= ordered;
        System.out.println("Вы заказали "+ ordered + " штук "+ productTitle+" за "+ordered*price +" евро");
        }
    }

    public void showProduct() {
        System.out.println(productTitle+" \n"+price+" \n"+availableQuantity + " ");
    }
}
