package com.giuseppeliguori.designpattern.behavioral.mediator;

/**
 * Created by Giuseppe on 27/05/2017.
 */
public class User {
    private String username;
    private int id;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sendMessage(User user, String message) {
        ChatRoomMediator.showMessage(user, message);
    }
}
