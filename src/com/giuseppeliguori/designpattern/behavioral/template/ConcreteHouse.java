package com.giuseppeliguori.designpattern.behavioral.template;

/**
 * Created by Giuseppe on 27/05/2017.
 */
public class ConcreteHouse extends HouseTemplate {

    @Override
    public void buildPillars() {
        System.out.println("ConcreteHouse.buildPillars");
    }

    @Override
    public void buildWalls() {
        System.out.println("ConcreteHouse.buildWalls");
    }
}
