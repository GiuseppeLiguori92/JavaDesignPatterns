package com.giuseppeliguori.designpattern.creational.abstractfactory;

import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.SpiderCar;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.SuvCar;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class CarFactory implements VehicleFactory {

    public enum CarType {
        SUV,
        SPIDER
    }

    @Override
    public Bike getBike(BikeFactory.BikeType bikeType) {
        return null;
    }

    @Override
    public Car getCar(CarType carType) {
        switch (carType) {
            case SPIDER:
                return new SpiderCar();
            case SUV:
                return new SuvCar();
            default:
                return null;
        }
    }
}
