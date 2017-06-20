package com.giuseppeliguori.solid.c__L;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class Fiesta implements Car {
    @Override
    public void openDoor() {
        System.out.println("Fiesta.openDoor");
    }

    @Override
    public void fuel() {
        System.out.println("Fiesta.fuel");
    }

    @Override
    public void accelerate() {
        System.out.println("Fiesta.accelerate");
    }

    @Override
    public void brake() {
        System.out.println("Fiesta.brake");
    }

    @Override
    public String getModel() {
        return "Fiesta";
    }
}
