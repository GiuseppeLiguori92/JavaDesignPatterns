package com.giuseppeliguori.designpattern.creational.builder;

/**
 * Created by giuseppeliguori on 04/05/2017.
 */
public class PersonBuilder {
    Person person;

    public PersonBuilder() {
        person = new Person();
    }

    public PersonBuilder setName(String name) {
        person.setName(name);
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        person.setSurname(surname);
        return this;
    }

    public PersonBuilder setAge(int age) {
        person.setAge(age);
        return this;
    }

    public PersonBuilder setSex(char sex) {
        person.setSex(sex);
        return this;
    }

    public Person build() {
        return person;
    }

}