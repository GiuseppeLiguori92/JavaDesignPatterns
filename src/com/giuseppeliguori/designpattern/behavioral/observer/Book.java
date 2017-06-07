package com.giuseppeliguori.designpattern.behavioral.observer;

/**
 * Created by giuseppeliguori on 02/06/2017.
 */
public class Book {
    private String title;
    private int code;

    public Book() {}

    public Book(String title, int code) {
        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", code=" + code +
                '}';
    }
}
