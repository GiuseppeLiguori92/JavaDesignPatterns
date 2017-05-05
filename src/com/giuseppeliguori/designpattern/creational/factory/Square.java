package com.giuseppeliguori.designpattern.creational.factory;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Square implements Shape {

    private int l;

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    @Override
    public int getArea() {
        System.out.println(toString());
        return l * l;
    }

    @Override
    public void setLenght(int l) {
        setL(l);
    }

    @Override
    public void setHeight(int h) {}

    @Override
    public void setRadius(int r) {}

    @Override
    public String toString() {
        return "Square{" +
                "l=" + l +
                '}';
    }
}
