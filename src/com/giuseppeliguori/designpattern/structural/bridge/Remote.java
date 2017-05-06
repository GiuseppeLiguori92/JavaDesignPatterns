package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public abstract class Remote {
    private Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void buttonUpPressed() {
        System.out.println("Remote.buttonUpPressed");
        device.buttonUpPressed();
    }

    public void buttonDownPressed() {
        System.out.println("Remote.buttonDownPressed");
        device.buttonDownPressed();
    }

    public abstract void buttonBluePressed();
}
