package com.valentyn.orders;

import java.util.HashMap;

public class OrdersHistory {
    private HashMap <Integer, String[]> history = new HashMap<>();
    public void setHistory (int orderNumber, String [] titleAndQuantity ) {
        history.put(orderNumber, titleAndQuantity);
    }

}
