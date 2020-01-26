package com.valentyn.discount;

import java.util.HashMap;

public class DiscountOperations {

    private int discount;
    DiscountVoucher vouchers = new DiscountVoucher();
    HashMap<String, Integer> existedVouchers = vouchers.getVouchers();


    public int checkDiscountExist(String discValue) {
        boolean exist;
        exist = existedVouchers.containsKey(discValue);
        if (exist == true) {
            discount = Integer.valueOf(existedVouchers.get(discValue));
        } else discount = 0;
        return discount;
    }
}
