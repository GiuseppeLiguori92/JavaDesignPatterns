package com.giuseppeliguori.designpattern.behavioral.chainofresponsibility;

/**
 * Created by giuseppeliguori on 02/06/2017.
 */
public class Boss extends Person {

    public Boss(Person nextPerson) {
        permissions.add(Request.INTERVIEW_NEW_CANDIDATE);
        permissions.add(Request.FIRE);
        role = Role.BOSS;
        this.nextPerson = nextPerson;
    }
}
