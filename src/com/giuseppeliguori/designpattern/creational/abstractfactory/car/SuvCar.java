package com.giuseppeliguori.designpattern.creational.abstractfactory.car;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class SuvCar implements Car {

    @Override
    public void refill() {
        System.out.println("SuvCar.refill");
    }

    @Override
    public void drive() {
        System.out.println("SuvCar.drive");
    }
}