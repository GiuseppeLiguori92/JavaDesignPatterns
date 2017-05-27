package com.giuseppeliguori.designpattern.behavioral.mediator;

import java.util.Date;

/**
 * Created by Giuseppe on 27/05/2017.
 */
public class ChatRoomMediator {
    public static void showMessage(User user, String message) {
        System.out.println("\n" + user.getUsername() + "[" + new Date().toString() + "]\n" + message + "");
    }
}
