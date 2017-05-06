package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class Gate extends Device {

    public Gate(DeviceState state) {
        deviceState = state;
    }

    @Override
    public void buttonUpPressed() {
        System.out.println("Gate.buttonUpPressed");
        deviceState = DeviceState.ON;
    }

    @Override
    public void buttonDownPressed() {
        System.out.println("Gate.buttonDownPressed");
        deviceState = DeviceState.OFF;
    }
}
