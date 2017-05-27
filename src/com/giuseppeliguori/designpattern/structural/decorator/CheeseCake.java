package com.giuseppeliguori.designpattern.structural.decorator;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class CheeseCake extends CakeDecorator {

    public CheeseCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        super.make();
        System.out.println("CheeseCake.make");
        addCheese();
    }

    private void addCheese() {
        System.out.println("CheeseCake.addCheese");
    }
}
