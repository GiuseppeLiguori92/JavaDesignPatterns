package com.giuseppeliguori.designpattern.creational.abstractfactory.bike;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class MountainBike implements Bike {
    @Override
    public void doPuncture() {
        System.out.println("MountainBike.doPuncture");
    }

    @Override
    public void drive() {
        System.out.println("MountainBike.drive");
    }

    @Override
    public void clean() {
        System.out.println("RoadBike.clean");
    }
}
