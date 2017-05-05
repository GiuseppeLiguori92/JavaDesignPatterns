package com.giuseppeliguori.designpattern.creational.factory;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class ShapeFactory {

    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    public Shape getShape(ShapeType type) {
        switch (type) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
