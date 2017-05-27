package com.giuseppeliguori.designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class ShapeFactory {

    private HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        SQUARE
    }

    public Shape getShape(ShapeType type) {
        Shape shape = shapes.get(type);
        if (shape == null) {
            shape = createShape(type);
            shapes.put(type, shape);
        }
        return shape;
    }

    public Shape createShape(ShapeType type) {
        Shape shape;
        switch (type) {
            case CIRCLE:
                System.out.println("Allocated new Circle");
                shape = new Circle();
                break;
            case RECTANGLE:
                System.out.println("Allocated new Rectangle");
                shape = new Rectangle();
                break;
            case SQUARE:
                System.out.println("Allocated new Square");
                shape = new Square();
                break;
            default:
                shape = null;
                break;
        }
        return shape;
    }
}
