package com.giuseppeliguori.designpattern.structural.decorator;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class CakeDecorator implements Cake {

    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void make() {
        System.out.println("CakeDecorator.make");
        cake.make();
    }
}
