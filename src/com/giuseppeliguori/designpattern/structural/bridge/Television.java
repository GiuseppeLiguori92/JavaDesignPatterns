package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class Television extends Device {

    public Television(DeviceState state) {
        deviceState = state;
    }

    @Override
    public void buttonUpPressed() {
        System.out.println("Television.buttonUpPressed");
        deviceState = DeviceState.ON;
    }

    @Override
    public void buttonDownPressed() {
        System.out.println("Television.buttonDownPressed");
        deviceState = DeviceState.OFF;
    }
}
