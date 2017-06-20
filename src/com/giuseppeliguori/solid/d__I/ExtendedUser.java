package com.giuseppeliguori.solid.d__I;

/**
 * Created by giuseppeliguori on 20/06/2017.
 */
public class ExtendedUser implements Registration, PhoneNumberRegistration, AddressRegistration {
    @Override
    public void inputEmail(String email) {
        System.out.println("ExtendedUser.inputEmail");
    }

    @Override
    public void inputPassword(String password) {
        System.out.println("ExtendedUser.inputPassword");
    }

    @Override
    public void inputAddress(String address) {
        System.out.println("ExtendedUser.inputAddress");
    }

    @Override
    public void inputPhoneNumber(String phoneNumber) {
        System.out.println("ExtendedUser.inputPhoneNumber");
    }
}
