package com.giuseppeliguori.designpattern.structural.facade;

/**
 * Created by giuseppeliguori on 16/05/2017.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}
