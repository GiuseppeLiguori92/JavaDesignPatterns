package com.giuseppeliguori.designpattern.structural.adapter;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class Person {
    private String name;
    private char sex;

    public Person(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public String getPersonValue() {
        return toString();
    }
}
