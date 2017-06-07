package com.giuseppeliguori.designpattern.behavioral.Strategy;

/**
 * Created by giuseppeliguori on 07/06/2017.
 */
public class Paypal implements PaymentMethod {

    public Paypal() {
        System.out.println("Paypal.Paypal auth");
    }

    @Override
    public void pay(float amount) {
        System.out.println("Paypal.pay " + amount);
    }
}
