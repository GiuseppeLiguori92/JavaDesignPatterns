package com.giuseppeliguori.solid.b__O;

/**
 * Created by giuseppeliguori on 19/06/2017.
 */
public class Square implements Shape {

    int base;

    public Square(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public long calculateArea() {
        return base * base;
    }
}
