package com.giuseppeliguori.designpattern.creational.abstractfactory;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class FactoryProducer {

    public enum VehicleType {
        BIKE,
        CAR
    }

    public VehicleFactory getVehicleFactory(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return new BikeFactory();
            case CAR:
                return new CarFactory();
            default:
                return null;
        }
    }
}
