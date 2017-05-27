package com.giuseppeliguori.designpattern.structural.facade;

/**
 * Created by giuseppeliguori on 16/05/2017.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw");
    }
}
