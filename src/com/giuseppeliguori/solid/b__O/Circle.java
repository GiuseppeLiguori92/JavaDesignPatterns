package com.giuseppeliguori.solid.b__O;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Circle implements Shape {
    long radius;

    public Circle(long radius) {
        this.radius = radius;
    }

    public long getRadius() {
        return radius;
    }

    public void setRadius(long radius) {
        this.radius = radius;
    }

    @Override
    public long calculateArea() {
        return (long) (radius * radius * Math.PI);
    }
}
