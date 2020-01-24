package com.valentyn.discount;

import java.util.HashMap;

public class DiscountVoucher {
    private HashMap<String, Integer> discount = new HashMap<>();
    public void setVouchers (String cardName, int discountPercent) {
        discount.put(cardName, discountPercent);
    }
    public HashMap getVouchers() {
     return discount;
    }
}
