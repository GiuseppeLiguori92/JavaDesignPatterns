package com.giuseppeliguori.designpattern.structural.proxy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Giuseppe on 13/05/2017.
 */
public class AuthenticationProxy implements AccessToRoom {
    private HashMap<String, String> passwords = new HashMap<>();
    private User user;

    public AuthenticationProxy(User user) {
        this.user = user;
        passwords.put("Hannah", "01201284darqweqwca");
        passwords.put("Robert", "812012faeh25432635");
        passwords.put("Alfred", "01249043c6135v1215");
    }

    private boolean authenticate() {
        Iterator iterator = passwords.entrySet().iterator();
        boolean authenticated = false;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String username = (String) entry.getKey();
            String password = (String) entry.getValue();

            if (user.getUsername().equals(username)) {
                if (user.getPassword().equalsIgnoreCase(password)) {
                    authenticated = true;
                    break;
                }
            }
        }

        if (!authenticated) {
            System.out.println("AuthenticationProxy.authenticate **WRONG PASSWORD/USERNAME**");
        }
        return authenticated;
    }

    @Override
    public void accessToPrivateRoom() {
        // Only hannah can access to the private room even if is authenticated
        if (authenticate() && user.getUsername().equalsIgnoreCase("Hannah")) {
            System.out.println("AuthenticationProxy.accessToPrivateRoom");
        } else {
            System.out.println("AuthenticationProxy. not allowed to accessToPrivateRoom");
        }
    }

    @Override
    public void accessToPublicRoom() {
        if (authenticate()) {
            System.out.println("AuthenticationProxy.accessToPublicRoom");
        } else {
            System.out.println("AuthenticationProxy. not allowed to accessToPublicRoom\n**Need auth**");
        }
    }
}
