package com.giuseppeliguori.designpattern.creational.abstractfactory.bike;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class RoadBike implements Bike {
    @Override
    public void doPuncture() {
        System.out.println("RoadBike.doPuncture");
    }

    @Override
    public void drive() {
        System.out.println("RoadBike.drive");
    }

    @Override
    public void clean() {
        System.out.println("RoadBike.clean");
    }
}
