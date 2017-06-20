package com.giuseppeliguori.solid.e__D;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class SpeedTest {
    private Test test;

    public SpeedTest() {
        System.out.println("SpeedTest.SpeedTest");
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void run(Test test) {
        this.test = test;
        this.test.startTest();
    }
}
