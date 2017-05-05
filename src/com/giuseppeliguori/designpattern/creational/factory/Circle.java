package com.giuseppeliguori.designpattern.creational.factory;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Circle implements Shape {
    private int r;

    public Circle() {}

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public int getArea() {
        System.out.println(toString());
        return (int) (Math.PI * r * r);
    }

    @Override
    public void setLenght(int l) {}

    @Override
    public void setHeight(int h) {}

    @Override
    public void setRadius(int r) {
        setR(r);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}
