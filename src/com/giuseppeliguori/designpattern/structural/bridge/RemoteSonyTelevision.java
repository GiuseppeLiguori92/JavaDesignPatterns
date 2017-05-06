package com.giuseppeliguori.designpattern.structural.bridge;

/**
 * Created by Giuseppe on 06/05/2017.
 */
public class RemoteSonyTelevision extends Remote {

    public RemoteSonyTelevision(Device device) {
        super(device);
    }

    @Override
    public void buttonBluePressed() {
        System.out.println("RemoteSonyTelevision.buttonBluePressed");
    }

}
