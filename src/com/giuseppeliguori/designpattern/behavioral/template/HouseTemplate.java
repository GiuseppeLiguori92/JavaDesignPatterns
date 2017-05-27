package com.giuseppeliguori.designpattern.behavioral.template;

/**
 * Created by Giuseppe on 27/05/2017.
 */
public abstract class HouseTemplate {

    // This method is common to all classes that want to extend this one,
    // all of those is going to use the same algorithm to build the house
    // build the foundation, windows and intern are common in all houses
    public HouseTemplate() {}

    // Template method, final so subclasses can't override
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        buildIntern();
    }

    private void buildFoundation() {
        System.out.println("HouseTemplate.buildFoundation");
    }

    public abstract void buildPillars();

    public abstract void buildWalls();

    private void buildWindows() {
        System.out.println("HouseTemplate.buildWindows");
    }

    private void buildIntern() {
        System.out.println("HouseTemplate.buildIntern");
    }
}
