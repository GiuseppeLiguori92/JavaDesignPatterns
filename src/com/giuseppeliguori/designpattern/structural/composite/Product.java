package com.giuseppeliguori.designpattern.structural.composite;

/**
 * Created by giuseppeliguori on 12/05/2017.
 */
public class Product implements ProductInterface {
    String name;
    Type type;
    float price;

    public enum Type {
        FOOD,
        DRINK
    }

    public Product(String name, Type type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
