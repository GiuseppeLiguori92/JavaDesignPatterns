package com.giuseppeliguori.designpattern.behavioral.Strategy;

/**
 * Created by giuseppeliguori on 07/06/2017.
 */
public class Cash implements PaymentMethod {

    public Cash() {
        System.out.println("Cash.Cash open wallet");
    }

    @Override
    public void pay(float amount) {
        System.out.println("Cash.pay: " + amount);
    }
}
