package com.giuseppeliguori.designpattern.creational.abstractfactory;

import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public interface VehicleFactory {
    Bike getBike(BikeFactory.BikeType bikeType);
    Car getCar(CarFactory.CarType carType);
}
