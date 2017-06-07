package com.giuseppeliguori.designpattern.behavioral.chainofresponsibility;

/**
 * Created by giuseppeliguori on 02/06/2017.
 */
public class Manager extends Person {

    public Manager(Person nextPerson) {
        permissions.add(Request.INTERVIEW_NEW_CANDIDATE);
        role = Role.MANAGER;
        this.nextPerson = nextPerson;
    }
}
