package com.giuseppeliguori.designpattern.structural.flyweight;

import java.awt.*;

/**
 * Created by giuseppeliguori on 16/05/2017.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }

    @Override
    public void setColor(Color color) {}

    @Override
    public void setCoordinate(Point point) {}

    @Override
    public void setDimension(int width, int height) {}
}
