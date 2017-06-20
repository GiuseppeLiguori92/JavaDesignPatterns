package com.giuseppeliguori.designpattern;

import com.giuseppeliguori.designpattern.behavioral.Strategy.*;
import com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Boss;
import com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Manager;
import com.giuseppeliguori.designpattern.behavioral.observer.Book;
import com.giuseppeliguori.designpattern.behavioral.observer.Library;
import com.giuseppeliguori.designpattern.behavioral.observer.LibraryObserver;
import com.giuseppeliguori.designpattern.behavioral.template.ConcreteHouse;
import com.giuseppeliguori.designpattern.behavioral.template.HouseTemplate;
import com.giuseppeliguori.designpattern.behavioral.template.WoodenHouse;
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
import com.giuseppeliguori.designpattern.structural.decorator.AppleCake;
import com.giuseppeliguori.designpattern.structural.decorator.BasicCake;
import com.giuseppeliguori.designpattern.structural.decorator.Cake;
import com.giuseppeliguori.designpattern.structural.decorator.CheeseCake;
import com.giuseppeliguori.designpattern.structural.proxy.User;
import com.giuseppeliguori.designpattern.structural.facade.ShapeDrawer;

import java.awt.*;
import java.util.*;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Hello world design patterns!");

        /**
         * Creational
         */

        abstractFactory();

        builder();

        factory();

        factoryMethod();

        prototype();

        signleton();

        /**
         * Structural
         */

        adapter();

        bridge();

        composite();

        decorator();

        facade();

        flyweight();

        proxy();

        /**
         * Behavioral
         */

        template();

        mediator();

        observer();

        chainofresponsibility();

        strategy();
    }

    private static void strategy() {
        com.giuseppeliguori.designpattern.behavioral.Strategy.Item pasta = new com.giuseppeliguori.designpattern.behavioral.Strategy.Item("Pasta", 3.45f);
        com.giuseppeliguori.designpattern.behavioral.Strategy.Item wine = new com.giuseppeliguori.designpattern.behavioral.Strategy.Item("Wine", 7.99f);
        com.giuseppeliguori.designpattern.behavioral.Strategy.Item tomatoes = new com.giuseppeliguori.designpattern.behavioral.Strategy.Item("Tomatoes", 1.70f);
        com.giuseppeliguori.designpattern.behavioral.Strategy.Item parmesan = new com.giuseppeliguori.designpattern.behavioral.Strategy.Item("Parmesan", 0.99f);

        Cart cart = new Cart();
        cart.addItem(pasta);
        cart.addItem(wine);
        cart.addItem(tomatoes);
        cart.addItem(parmesan);

        PaymentMethod paymentMethod = new Cash();
        cart.pay(paymentMethod);

        PaymentMethod paymentMethod2 = new Card();
        cart.pay(paymentMethod2);

        PaymentMethod paymentMethod3 = new Paypal();
        cart.pay(paymentMethod3);
    }

    private static void chainofresponsibility() {;
        Boss boss = new Boss(null);
        Manager manager = new Manager(boss);

        manager.processRequest(com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Person.Request.INTERVIEW_NEW_CANDIDATE);
        manager.processRequest(com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Person.Request.FIRE);
        boss.processRequest(com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Person.Request.INTERVIEW_NEW_CANDIDATE);
        boss.processRequest(com.giuseppeliguori.designpattern.behavioral.chainofresponsibility.Person.Request.FIRE);

    }

    private static void observer() {
        Book book1 = new Book("Here we are!", 4214);
        Book book2 = new Book("48 hours to escape", 5451);
        Book book3 = new Book("Nothing is all", 1235);
        Book book4 = new Book("Let's discover the world", 9241);

        Library library = new Library();
        library.addObserver(new LibraryObserver() {
            @Override
            public void onBookBorrowed(Book book) {
                System.out.println("main.onBookBorrowed: " + book.getTitle());
            }

            @Override
            public void onBookNotAvailable(Book book) {
                System.out.println("main.onBookNotAvailable: " + book.getTitle());
            }

            @Override
            public void onBookReturned(Book book) {
                System.out.println("main.onBookReturned: " + book.getTitle());
            }

            @Override
            public void onBookAdded(Book book) {
                System.out.println("main.onBookAdded: " + book.getTitle());
            }
        });

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Borrow a book
        library.borrowBook(book2);

        // Borrow another book, unfortunately this book has already been borrowed
        library.borrowBook(book2);

        // Add book
        library.addBook(book4);

        // Return book
        library.returnBook(book2);
    }

    // Mediator pattern is used to reduce communication complexity between multiple objects or classes.
    // This pattern provides a mediator class which normally handles all the communications
    // between different classes and supports easy maintenance of the code by loose coupling.
    private static void mediator() {
        com.giuseppeliguori.designpattern.behavioral.mediator.User giuseppe = new com.giuseppeliguori.designpattern.behavioral.mediator.User("Giuseppe L.", 213);
        com.giuseppeliguori.designpattern.behavioral.mediator.User sara = new com.giuseppeliguori.designpattern.behavioral.mediator.User("Sara C.", 213);

        giuseppe.sendMessage(sara, "I love you <3");
        sara.sendMessage(giuseppe, "Me too, so much!");
    }

    /**
     * Template method defines the steps to execute an algorithm and it can provide default
     * implementation that might be common for all or some of the subclasses.
     */
    private static void template() {
        System.out.println("\n\n**Template");
        // We are going to build 2 different houses but with the
        // same algorithm to build it
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        HouseTemplate concreteHouse = new ConcreteHouse();
        concreteHouse.buildHouse();

    }

    private static void proxy() {
        System.out.println("\n\n**Proxy");
        User user = new User("Giuseppe", "249710974");
        user.accessToPrivateRoom();
        user.accessToPublicRoom();

        User user2 = new User("Hannah", "01201284darqweqwca");
        user2.accessToPrivateRoom();
        user2.accessToPublicRoom();

        User user3 = new User("Alfred", "01249043c6135v1215");
        user3.accessToPrivateRoom();
        user3.accessToPublicRoom();
    }

    private static void decorator() {
        System.out.println("\n\n**Decorator");

        Cake appleCake = new AppleCake(new BasicCake());
        appleCake.make();

        Cake cheeseCake = new CheeseCake(new BasicCake());
        cheeseCake.make();
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
        Car convertibleCar = carFactory.getCar(CarFactory.CarType.CONVERTIBLE);
        convertibleCar.refill();
        convertibleCar.drive();

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
