package com.valentyn.discount;

import java.util.HashMap;

public class DiscountOperations {

    private int discount = 0;
    DiscountVoucher vouchers = new DiscountVoucher();
    HashMap<String, Integer> existedVouchers = vouchers.getVouchers();


    public boolean checkDiscountExist(String discValue) {
        boolean exist = false;
        exist = existedVouchers.containsValue(discValue);
        if (exist == true) {
            discount = existedVouchers.get(discValue);
        }
        return exist;
    }

    public int getDiscount() {
        return discount;
    }
}
