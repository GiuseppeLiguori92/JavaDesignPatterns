package com.giuseppeliguori.designpattern;

import com.giuseppeliguori.designpattern.creational.singleton.Item;
import com.giuseppeliguori.designpattern.creational.singleton.StorageSingleton;
import com.giuseppeliguori.designpattern.creational.abstractfactory.*;
import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.BikeFactory;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;
import com.giuseppeliguori.designpattern.creational.abstractfactory.CarFactory;
import com.giuseppeliguori.designpattern.creational.builder.Person;
import com.giuseppeliguori.designpattern.creational.builder.PersonBuilder;
import com.giuseppeliguori.designpattern.creational.factory.Shape;
import com.giuseppeliguori.designpattern.creational.factory.ShapeFactory;
import com.giuseppeliguori.designpattern.creational.prototype.Computer;
import com.giuseppeliguori.designpattern.creational.prototype.ComputerCache;
import com.giuseppeliguori.designpattern.structural.adapter.DataAdapter;
import com.giuseppeliguori.designpattern.structural.adapter.DataPresenter;

import java.util.*;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Hello world design patterns!");

        // TODO **Creational**

        builder();

        factory();

        abstractFactory();

        signleton();

        prototype();


        // TODO **Structural**

        adapter();
    }

    private static void adapter() {

        System.out.println("\n\n**Adapter");
        // Create data list
        HashMap<Integer, Object> data = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (new Random().nextBoolean()) {
                com.giuseppeliguori.designpattern.structural.adapter.Item item = new com.giuseppeliguori.designpattern.structural.adapter.Item(new Random().nextInt(100), "Item");
                data.put(i, item);
            } else {
                com.giuseppeliguori.designpattern.structural.adapter.Person person = new com.giuseppeliguori.designpattern.structural.adapter.Person("Person", new Random().nextBoolean() ? 'M' : 'F');
                data.put(i, person);
            }
        }

        DataAdapter dataAdapter = new DataAdapter(data);
        DataPresenter dataPresenter = new DataPresenter(dataAdapter);
    }

    private static void signleton() {
        System.out.println("\n\n**Singleton");
        // Example: Use singleton if you have only one place where you store your things
        Item itemBox = new Item(1231, "Box");
        Item itemFood = new Item(6113, "Food");

        StorageSingleton.getInstance().storeItem(itemBox);
        StorageSingleton.getInstance().storeItem(itemFood);

        Item itemBoxFromSignleton = StorageSingleton.getInstance().getItem(1231);
        Item itemFoodFromSignleton = StorageSingleton.getInstance().getItem(6113);
    }

    private static void prototype() {
        System.out.println("\n\n**Prototype");
        // Create the object
        Computer computer = new Computer();
        computer.setName("MacBook Pro 2017");
        computer.setCpuId(34567);
        computer.setId(231);
        computer.setMoterBoardYearRelease(2017);
        computer.setCpuId(53422);
        // Etc... better to use a builder if is a complex object!

        // Store in cache
        final ComputerCache computerCache = new ComputerCache();
        computerCache.storeComputerInCache(computer);
        System.out.println(computerCache.toString());

        doLongOperation(new OnLongOperationEventListener() {
            @Override
            public void onLongOperationStart() {
                System.out.println("main.onLongOperationStart");
            }

            @Override
            public void onLongOperationRunning() {
                System.out.println("main.onLongOperationRunning");
            }

            @Override
            public void onLongOperationEnd() {
                System.out.println("main.onLongOperationEnd");
                Computer computer2 = computerCache.getComputer(computer.getId());
                computer2.setId(252);
                computer2.setName("Lenovo UT235");
                computer2.setMotherBoardId(98123);
                computerCache.storeComputerInCache(computer2);
                System.out.println(computerCache.toString());
            }
        });

    }

    private static void doLongOperation(OnLongOperationEventListener onLongOperationEventListener) {
        new Thread( () -> {
            onLongOperationEventListener.onLongOperationStart();
            // Execute a long operation,
            // example: httpRequest + process json + store in local database + store in database online
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                onLongOperationEventListener.onLongOperationRunning();
                System.out.println("Thread.prototype.longOperation");
                if (counter == 3) {
                    break;
                }
                counter++;
            }
            onLongOperationEventListener.onLongOperationEnd();
        }).start();
    }

    private interface OnLongOperationEventListener {
        void onLongOperationStart();
        void onLongOperationRunning();
        void onLongOperationEnd();
    }

    private static void abstractFactory() {
        FactoryProducer factoryProducer = new FactoryProducer();

        VehicleFactory carFactory = factoryProducer.getVehicleFactory(FactoryProducer.VehicleType.CAR);
        Car suvCar = carFactory.getCar(CarFactory.CarType.SUV);
        suvCar.refill();
        suvCar.drive();
        Car spiderCar = carFactory.getCar(CarFactory.CarType.SPIDER);
        spiderCar.refill();
        spiderCar.drive();

        VehicleFactory bikeFactory = factoryProducer.getVehicleFactory(FactoryProducer.VehicleType.BIKE);
        Bike roadBike = bikeFactory.getBike(BikeFactory.BikeType.ROAD);
        roadBike.doPuncture();
        roadBike.drive();
        Bike mountainBike = bikeFactory.getBike(BikeFactory.BikeType.MOUNTAIN);
        mountainBike.clean();
        mountainBike.drive();
    }

    public static void builder() {
        System.out.println("\n\n**Builder");
        // Builder
        Person person1 = new PersonBuilder()
                .setName("Giuseppe")
                .setSurname("L")
                .setAge(26)
                .build();

        System.out.println(person1.toString());
        Person person2 = new PersonBuilder()
                .setName("Hannah")
                .setAge(24)
                .setSex('F')
                .build();

        System.out.println(person2.toString());
    }

    private static void factory() {
        System.out.println("\n\n**Factory");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);
        circle.setRadius(20);
        System.out.println(circle.getArea());
        Shape square = shapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);
        square.setLenght(50);
        System.out.println(square.getArea());
        Shape rectangle = shapeFactory.getShape(ShapeFactory.ShapeType.RECTANGLE);
        rectangle.setLenght(10);
        rectangle.setHeight(20);
        System.out.println(rectangle.getArea());
    }
}
