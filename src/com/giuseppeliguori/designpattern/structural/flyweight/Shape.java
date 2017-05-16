package com.giuseppeliguori.designpattern.structural.flyweight;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by giuseppeliguori on 16/05/2017.
 */
public interface Shape {
    void draw();
    void setColor(Color color);
    void setCoordinate(Point point);
    void setDimension(int width, int height);
}
