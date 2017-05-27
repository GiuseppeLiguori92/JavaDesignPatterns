package com.giuseppeliguori.designpattern.structural.proxy;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class User implements AccessToRoom {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void accessToPrivateRoom() {
        System.out.println(username + " try to User.accessToPrivateRoom");
        AuthenticationProxy authenticationProxy = new AuthenticationProxy(this);
        authenticationProxy.accessToPrivateRoom();
    }

    @Override
    public void accessToPublicRoom() {
        System.out.println(username + " try to User.accessToPublicRoom");
        AuthenticationProxy authenticationProxy = new AuthenticationProxy(this);
        authenticationProxy.accessToPrivateRoom();
    }
}
