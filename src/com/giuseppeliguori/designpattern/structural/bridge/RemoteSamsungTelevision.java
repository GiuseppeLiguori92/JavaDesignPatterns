package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class RemoteSamsungTelevision extends Remote {

    public RemoteSamsungTelevision(Device device) {
        super(device);
    }

    @Override
    public void buttonBluePressed() {
        System.out.println("RemoteSamsungTelevision.buttonBluePressed");
    }

}
