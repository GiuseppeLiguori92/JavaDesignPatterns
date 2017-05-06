package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public abstract class Device {

    public DeviceState deviceState;

    public enum DeviceState {
        ON,
        OFF
    }

    public abstract void buttonUpPressed();
    public abstract void buttonDownPressed();

}
