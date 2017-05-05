package com.giuseppeliguori.tolearn.labda;

import com.giuseppeliguori.designpattern.creational.abstractfactory.BikeFactory;
import com.giuseppeliguori.designpattern.creational.abstractfactory.CarFactory;
import com.giuseppeliguori.designpattern.creational.abstractfactory.FactoryProducer;
import com.giuseppeliguori.designpattern.creational.abstractfactory.VehicleFactory;
import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;
import com.giuseppeliguori.designpattern.creational.builder.Person;
import com.giuseppeliguori.designpattern.creational.builder.PersonBuilder;
import com.giuseppeliguori.designpattern.creational.factory.Shape;
import com.giuseppeliguori.designpattern.creational.factory.ShapeFactory;
import com.giuseppeliguori.designpattern.creational.prototype.Computer;
import com.giuseppeliguori.designpattern.creational.prototype.ComputerCache;
import com.giuseppeliguori.designpattern.creational.singleton.Item;
import com.giuseppeliguori.designpattern.creational.singleton.StorageSingleton;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        new Lambda();
    }
}
