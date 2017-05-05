package com.giuseppeliguori.designpattern.creational.factory;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Rectangle implements Shape {

    private int h;
    private int l;

    public Rectangle() {}

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    @Override
    public int getArea() {
        System.out.println(toString());
        return l * h;
    }

    @Override
    public void setLenght(int l) {
        setL(l);
    }

    @Override
    public void setHeight(int h) {
        setH(h);
    }

    @Override
    public void setRadius(int r) {}

    @Override
    public String toString() {
        return "Rectangle{" +
                "h=" + h +
                ", l=" + l +
                '}';
    }
}
