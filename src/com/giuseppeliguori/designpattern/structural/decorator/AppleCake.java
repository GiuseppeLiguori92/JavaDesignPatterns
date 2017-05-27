package com.giuseppeliguori.designpattern.structural.decorator;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class AppleCake extends CakeDecorator {

    public AppleCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        super.make();
        System.out.println("AppleCake.make");
        addApple();
    }

    private void addApple() {
        System.out.println("AppleCake.addApple");
    }
}
