package com.giuseppeliguori.designpattern.behavioral.template;

/**
 * Created by Giuseppe on 27/05/2017.
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    public void buildPillars() {
        System.out.println("WoodenHouse.buildPillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("WoodenHouse.buildWalls");
    }
}
