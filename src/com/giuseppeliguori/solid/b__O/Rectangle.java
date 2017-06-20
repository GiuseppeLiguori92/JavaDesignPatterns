package com.giuseppeliguori.solid.b__O;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Rectangle implements Shape {
    long width;
    long height;

    public Rectangle(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public long calculateArea() {
        return width * height;
    }
}
