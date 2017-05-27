package com.giuseppeliguori.designpattern.structural.decorator;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class BasicCake implements Cake {
    @Override
    public void make() {
        System.out.println("Add floor");
        System.out.println("Add sugar");
        System.out.println("Add eggs");
        System.out.println("Add yeast");
        System.out.println("BasicCake.make");
    }
}
