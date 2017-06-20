package com.giuseppeliguori.solid.e__D;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class PingTest implements Test {
    @Override
    public void startTest() {
        System.out.println("PingTest.startTest");
    }

    @Override
    public void getResult() {
        System.out.println("PingTest.getResult");
    }
}
