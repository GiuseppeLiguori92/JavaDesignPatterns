package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class RemoteGateTwo extends Remote {

    public RemoteGateTwo(Device device) {
        super(device);
    }

    @Override
    public void buttonBluePressed() {
        System.out.println("RemoteGateTwo.buttonBluePressed");
    }

}
