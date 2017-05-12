package com.giuseppeliguori.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giuseppeliguori on 12/05/2017.
 */
public class Meal implements ProductInterface {
    List<Product> products = new ArrayList<>();
    float price;

    public Meal() {}

    public void addProduct(Product product) {
        products.add(product);
        price += product.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : products) {
            stringBuilder.append("["+product.getType()+"] " + product.getName() + " $" + product.getPrice() + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public float getPrice() {
        return price;
    }
}
