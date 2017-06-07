package com.giuseppeliguori.designpattern.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giuseppeliguori on 02/06/2017.
 */
public abstract class Person {
    public enum Request {
        INTERVIEW_NEW_CANDIDATE,
        FIRE
    }

    public enum Role {
        MANAGER,
        BOSS
    }

    public Person nextPerson;
    public Role role;
    public List<Request> permissions = new ArrayList<>();

    public void askToProcessToNextRole(Request request) {
        nextPerson.processRequest(request);
    }

    public void processRequest(Request request) {
        if (permissions.contains(request)) {
            System.out.println(role + ".processRequest: " + request);
        } else {
            System.out.println(role + ".skippedRequestTo: " + nextPerson.role);
            askToProcessToNextRole(request);
        }
    }
}
