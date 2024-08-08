package com.edu.poly.major.global;

import com.edu.poly.major.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    //tao bien toan cuc
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

}
