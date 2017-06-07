package com.giuseppeliguori.designpattern.behavioral.Strategy;

/**
 * Created by giuseppeliguori on 07/06/2017.
 */
public class Card implements PaymentMethod {

    public Card() {
        System.out.println("Card.Card input pin");
    }

    @Override
    public void pay(float amount) {
        System.out.println("Card.pay: " + amount);
    }
}
