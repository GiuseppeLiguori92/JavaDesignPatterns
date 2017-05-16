package com.giuseppeliguori.designpattern;

import com.giuseppeliguori.designpattern.creational.factory.Circle;
import com.giuseppeliguori.designpattern.creational.factory.Rectangle;
import com.giuseppeliguori.designpattern.creational.factory.Shape;
import com.giuseppeliguori.designpattern.creational.factory.ShapeFactory;
import com.giuseppeliguori.designpattern.creational.factory.Square;
import com.giuseppeliguori.designpattern.creational.singleton.Item;
import com.giuseppeliguori.designpattern.creational.singleton.StorageSingleton;
import com.giuseppeliguori.designpattern.creational.abstractfactory.*;
import com.giuseppeliguori.designpattern.creational.abstractfactory.bike.Bike;
import com.giuseppeliguori.designpattern.creational.abstractfactory.BikeFactory;
import com.giuseppeliguori.designpattern.creational.abstractfactory.car.Car;
import com.giuseppeliguori.designpattern.creational.abstractfactory.CarFactory;
import com.giuseppeliguori.designpattern.creational.builder.Person;
import com.giuseppeliguori.designpattern.creational.builder.PersonBuilder;
import com.giuseppeliguori.designpattern.creational.prototype.Computer;
import com.giuseppeliguori.designpattern.creational.prototype.ComputerCache;
import com.giuseppeliguori.designpattern.structural.adapter.DataAdapter;
import com.giuseppeliguori.designpattern.structural.adapter.DataPresenter;
import com.giuseppeliguori.designpattern.structural.bridge.*;
import com.giuseppeliguori.designpattern.structural.composite.Meal;
import com.giuseppeliguori.designpattern.structural.composite.Product;
import com.giuseppeliguori.designpattern.structural.facade.ShapeDrawer;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.*;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Hello world design patterns!");

//        // TODO **Creational**
//
//        builder();
//
//        factory();
//
//        factoryMethod();
//
//        abstractFactory();
//
//        signleton();
//
//        prototype();
//
//        // TODO **Structural**
//
//        adapter();
//
//        bridge();
//
//        composite();
//
//        facade();
        
        flyweight();
        
        

    }

    /**
     * Flyweight design pattern is used when we need to create a lot of Objects of a class.
     * Since every object consumes memory space that can be crucial for low memory devices,
     * such as mobile devices or embedded systems, flyweight design pattern can be applied
     * to reduce the load on memory by sharing objects.
     */
    private static void flyweight() {
        long now = System.currentTimeMillis();
        com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory shapeFactory = new com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory();

        // Create a loooooot of shapes, you can see the results if you follow the _TODO in the Shapefactory class
        Random random = new Random(3);
        com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory.ShapeType type = null;
        int randomType = -1;
        for (int i = 0; i < 1000000; i++) {
            randomType = random.nextInt(3);
            switch (randomType) {
                case 0:
                    type = com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory.ShapeType.CIRCLE;
                    break;
                case 1:
                    type = com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory.ShapeType.SQUARE;
                    break;
                case 2:
                    type = com.giuseppeliguori.designpattern.structural.flyweight.ShapeFactory.ShapeType.RECTANGLE;
                    break;
            }

            com.giuseppeliguori.designpattern.structural.flyweight.Shape shape = shapeFactory.getShape(type);
            shape.setColor(Color.BLUE);
            shape.setCoordinate(new Point(random.nextInt(1280), random.nextInt(800)));
            shape.setDimension(random.nextInt(30), random.nextInt(60));
        }
    }

    /**
     * Facade pattern hides the complexities of the system and provides an interface to the client
     * using which the client can access the system.
     * This type of design pattern comes under structural pattern as this pattern adds an interface
     * to existing system to hide its complexities.
     * This pattern involves a single class which provides simplified methods required by client
     * and delegates calls to methods of existing system classes
     */
    private static void facade() {
        ShapeDrawer shapeDrawer = new ShapeDrawer();
        shapeDrawer.drawCircle();
        shapeDrawer.drawRectangle();
        shapeDrawer.drawSquare();
    }

    private static void composite() {
        System.out.println("\n\n**Composite");
        Product hamburger = new Product("Hamburger", Product.Type.FOOD, 5.99f);
        Product pepsi = new Product("Pepsi", Product.Type.DRINK, 1.49f);
        Product icecream = new Product("Ice Cream", Product.Type.FOOD, 0.99f);
        Meal meal = new Meal();
        meal.addProduct(hamburger);
        meal.addProduct(pepsi);
        meal.addProduct(icecream);

        System.out.println(meal.toString());
        System.out.println(String.format("Meal price: $%.02f",meal.getPrice()));

    }

    private static void bridge() {
        System.out.println("\n\n**Bridge");

        Device television = new Television(Device.DeviceState.OFF);

        Remote samsungRemote = new RemoteSamsungTelevision(television);
        samsungRemote.buttonUpPressed();
        samsungRemote.buttonDownPressed();
        samsungRemote.buttonBluePressed();

        Remote sonyRemote = new RemoteSamsungTelevision(television);
        sonyRemote.buttonUpPressed();
        sonyRemote.buttonDownPressed();
        sonyRemote.buttonBluePressed();

        Device gate = new Gate(Device.DeviceState.OFF);

        Remote remoteGateOne = new RemoteGateOne(gate);
        remoteGateOne.buttonBluePressed();

        Remote remoteGateTwo = new RemoteGateTwo(gate);
        remoteGateTwo.buttonBluePressed();
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

    private static void factoryMethod() {
        System.out.println("\n\n**FactoryMethod");
        // Get the input from someone
        ShapeFactory.ShapeType input = ShapeFactory.ShapeType.CIRCLE;
        Shape shape = getShape(input);
        shape.setRadius(10);
        shape.getArea();
    }

    private static Shape getShape(ShapeFactory.ShapeType type) {
        switch (type) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                return null;
        }
    }

    private static void factory() {
        System.out.println("\n\n**Factory");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);
        circle.setRadius(20);
        System.out.println(circle.getArea());
        Shape square = shapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);
        square.setLength(50);
        System.out.println(square.getArea());
        Shape rectangle = shapeFactory.getShape(ShapeFactory.ShapeType.RECTANGLE);
        rectangle.setLength(10);
        rectangle.setHeight(20);
        System.out.println(rectangle.getArea());
    }
}
