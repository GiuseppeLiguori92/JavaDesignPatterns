package com.giuseppeliguori.solid.d__I;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class SimpleUser implements Registration {
    @Override
    public void inputEmail(String email) {
        System.out.println("SimpleUser.inputEmail");
    }

    @Override
    public void inputPassword(String password) {
        System.out.println("SimpleUser.inputPassword");
    }
}
