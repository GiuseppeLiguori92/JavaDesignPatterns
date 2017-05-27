package com.giuseppeliguori.designpattern.structural.facade;

/**
 * Created by giuseppeliguori on 16/05/2017.
 */
public class ShapeDrawer {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public ShapeDrawer() {
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
