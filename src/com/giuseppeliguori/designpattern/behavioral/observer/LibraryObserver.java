package com.giuseppeliguori.designpattern.behavioral.observer;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */
public interface LibraryObserver {
    void onBookBorrowed(Book book);
    void onBookNotAvailable(Book book);
    void onBookReturned(Book book);
    void onBookAdded(Book book);
}
