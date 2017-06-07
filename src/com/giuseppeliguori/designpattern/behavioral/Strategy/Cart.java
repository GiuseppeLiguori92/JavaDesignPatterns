package com.giuseppeliguori.designpattern.behavioral.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giuseppeliguori on 07/06/2017.
 */
public class Cart {
    private List<Item> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    public void pay(PaymentMethod paymentMethod) {
        int amount = 0;
        for (Item item : cart) {
            amount += item.getPrice();
        }
        paymentMethod.pay(amount);
    }

}
