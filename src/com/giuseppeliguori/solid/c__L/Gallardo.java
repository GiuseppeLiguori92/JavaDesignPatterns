package com.giuseppeliguori.solid.c__L;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class Gallardo implements Car, Convertible {
    @Override
    public void openDoor() {
        System.out.println("Gallardo.openDoor");
    }

    @Override
    public void fuel() {
        System.out.println("Gallardo.fuel");
    }

    @Override
    public void accelerate() {
        System.out.println("Gallardo.accelerate");
    }

    @Override
    public void brake() {
        System.out.println("Gallardo.brake");
    }

    @Override
    public String getModel() {
        return "Gallardo";
    }

    @Override
    public void openSunroof() {
        System.out.println("Gallardo.openSunroof");
    }
}
