package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class RemoteGateOne extends Remote {

    public RemoteGateOne(Device device) {
        super(device);
    }

    @Override
    public void buttonBluePressed() {
        System.out.println("RemoteGateOne.buttonBluePressed");
    }

}
