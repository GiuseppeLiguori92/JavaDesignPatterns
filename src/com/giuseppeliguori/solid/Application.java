package com.giuseppeliguori.solid;

import com.giuseppeliguori.solid.a__S.Document;
import com.giuseppeliguori.solid.a__S.Printer;
import com.giuseppeliguori.solid.b__O.*;
import com.giuseppeliguori.solid.c__L.Car;
import com.giuseppeliguori.solid.c__L.Convertible;
import com.giuseppeliguori.solid.c__L.Fiesta;
import com.giuseppeliguori.solid.c__L.Gallardo;
import com.giuseppeliguori.solid.d__I.ExtendedUser;
import com.giuseppeliguori.solid.d__I.SimpleUser;
import com.giuseppeliguori.solid.e__D.DownloadTest;
import com.giuseppeliguori.solid.e__D.PingTest;
import com.giuseppeliguori.solid.e__D.SpeedTest;
import com.giuseppeliguori.solid.e__D.UploadTest;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Application {
    public Application() {

        //TODO*** S Single responsibility principle *************************************************************************************
        System.out.println("\n\nApplication.Application");

        // The way to write a file and print it has been decoupled in 2 classes, if in future
        // i want to add a new kind of file i can do it easily just editing the Document class
        // the printer will ever accept a sequence of bytes and print them (sent to the real device)

        Document txt = new Document("Hi, this is the first file");
        Document image = new Document(new byte[]{0x10, 0x33, 0x7B, 0x0F, 0x4D, 0x0F, 0x34, 0x0D});

        Printer printer = new Printer();

        printer.print(txt);
        printer.print(image);





        //TODO*** O Open to extension closed to modification ***************************************************************************************
        System.out.println("\n\nApplication.Application");
        // We should write code that doesn't have to be changed every time
        // the requirements change

        // Example, we have a rectangle and a circle and another class that allow
        // to calculate area of all of them
        // calculateRectangleArea()
        // calculateCircleArea()

        // Now, i want to add a square class, and then i need to edit and change the
        // class AreaCalculator adding the new method calculateSquareArea(), this is wrong,
        // the best way should be to create a shape class (Square, Circle ecc.) and extend if
        // we want an abstract class or implement an interface that allow to define a method calculateArea
        // and then we'll have a class AreaCalculator with a method calculateArea(..) passing
        // a shape parameter

        Shape circle = new Circle(20);
        Shape rectangle = new Rectangle(10, 30);

        AreaCalculator areaCalculator = new AreaCalculator();
        long totalArea = 0;
        totalArea += areaCalculator.calculateArea(circle);
        totalArea += areaCalculator.calculateArea(rectangle);

        System.out.println("Application.Application: " + totalArea);

        // In future i want to add a Square
        // I will just create a Square class and i will implement the interface Shape
        // then if i want to calculate the total area, i will just pass the Square to
        // areaCalculator and get the value.

        // The square example is a stupid example, because basically is a rectangle.
        // But is just to explain how it works

        Shape square = new Square(10);
        totalArea += square.calculateArea();

        System.out.println("Application.Application: " + totalArea);





        //TODO*** L Liskov’s Substitution Principle ***************************************************************************************
        System.out.println("\n\nApplication.Application");

        // It means that the classes fellow developer created by extending your class
        // should be able to fit in application without failure. I.e.
        // if a fellow developer poorly extended some part of your class and injected into framework/
        // application then it should not break the application or should not throw fatal exceptions.

        Fiesta fiesta = new Fiesta();
        fiesta.openDoor();
        fiesta.fuel();
        fiesta.accelerate();
        fiesta.brake();

        // What does it means?
        // In this example we have cars, but there are different kind.
        // Example of a convertible car, it has a property the common car hasn't: you can open the sunroof!
        // The bad way to do it is to create an abstract class the create all the methods.
        // and when you have a normal class and try to call openSunroof() it will give you an exception
        // because is not possible to open it.
        // Another case might be to set a boolean variable sunroofOpenable, but in this way we are just
        // applying a patch. In future if i want to add another property i will need to change that class.
        // And we're gonna violate the second principle (Open/close classes)

        // The best way to do it, is to create different interfaces that implements different properties
        // In this example we have the Car interface, that implement the common method to all cars.
        // Then we have Convertible interface that implement the method openSunroof().

        // When i have a convertible car i will just implement the Car and then Convertible interfaces.

        Gallardo gallardo = new Gallardo();
        gallardo.openDoor();
        gallardo.fuel();
        gallardo.accelerate();
        gallardo.brake();
        // It is a convertible car, i can open the sunroof
        gallardo.openSunroof();

        // In future i have to create a Camper interface that for example implement the methods cook() and dischargeWastes()
        // i can do it easily creating a new class the implement Car and then Camper


        // I might need to check if a car is a Convertible car or not,
        // I have to check this in the main of the application and not
        // in the Car class.

        Car car = fiesta;
        isConvertible(car);

        car = gallardo;
        isConvertible(car);




        //TODO*** I Interface segregation principle ***************************************************************************************
        System.out.println("\n\nApplication.Application");

        // that clients should not be forced to implement interfaces they don't use.
        // Instead of one fat interface many small interfaces are preferred based
        // on groups of methods, each one serving one submodule.

        // Example SIMPLE user registration, this module force the use to write an email and a password.
        // A bad design will implement also to write the phone number and address.
        // BAD
        // public interface UserRegistration {
        //      void inputEmail();
        //      void inputPassword();
        //      void inputPhoneNumber();
        //      void inputAddress();
        // }
        //
        // In this way we are forcing the user to create a class and implement all of those methods.
        //
        // The best way to do it is to decouple the fat* interface in more interfaces
        // Registration then PhoneNumberRegistration and AddressRegistration

        // We are gonna have two kind of users registration, simple (just email and password) and then extended (add phone and address)
        // we might even create other 2 kind of user with just one of the interfaces:
        // 1) email, password and PHONE
        // 1) email, password and ADDRESS

        SimpleUser simpleUser = new SimpleUser();
        simpleUser.inputEmail("email");
        simpleUser.inputPassword("password");

        ExtendedUser extendedUser = new ExtendedUser();
        extendedUser.inputEmail("email");
        extendedUser.inputPassword("password");
        extendedUser.inputPhoneNumber("1234567890");
        extendedUser.inputAddress("address");




        //TODO*** D Dependency inversion principle ***************************************************************************************
        System.out.println("\n\nApplication.Application");
        // High-level modules should not depend on low-level modules. Both should depend on abstractions.

        // We are using the example of a speedtest, that might run a download upload and ping test.

        // A bad design would be:
        // Create the class Speedtest and create two objects DownloadSpeedtest and UploadSpeedtest
        // then i can run the two tests.
        // If i want to add another kind of test, as for example PingTest i need to change the Speedtest class, that
        // in future is gonna be really complicated to understand and edit

        // In this example we are creating the Speedtest class that implement an object Test, that is the interface of
        // the object DownloadTest, UploadTest this allow to call the method run()
        // When i will add the new Ping test, it will be easy to create it without changing the Speedtest class.
        // Follow the example to understand better

        DownloadTest downloadTest = new DownloadTest();
        UploadTest uploadTest = new UploadTest();

        SpeedTest speedTest = new SpeedTest();
        speedTest.run(downloadTest);
        speedTest.run(uploadTest);

        // I have now created the new PingTest without changing to Speedtest class
        // and i can run it.

        PingTest pingTest = new PingTest();
        speedTest.run(pingTest);
    }

    public void isConvertible(Car car) {
        if (car instanceof Convertible) {
            System.out.println(car.getModel() + " is a convertible car");
        } else {
            System.out.println(car.getModel() + " is not a convertible");
        }
    }
}
