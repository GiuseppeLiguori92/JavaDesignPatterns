package com.giuseppeliguori.designpattern.creational.abstractfactory;

import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.MountainBike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.RoadBike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class BikeFactory implements VehicleFactory {

    public enum BikeType {
        ROAD,
        MOUNTAIN
    }

    @Override
    public Bike getBike(BikeType bikeType) {
        switch (bikeType) {
            case MOUNTAIN:
                return new MountainBike();
            case ROAD:
                return new RoadBike();
            default:
                    return null;
        }

    }

    @Override
    public Car getCar(CarFactory.CarType carType) {
        return null;
    }
}
