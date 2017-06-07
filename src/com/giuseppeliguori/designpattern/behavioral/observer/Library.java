package com.giuseppeliguori.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by giuseppeliguori on 29/05/2017.
 */
public class Library {
    private List<Book> books;
    private LibraryObserver libraryObserver;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            // Notify observer
            if (libraryObserver != null) {
                libraryObserver.onBookAdded(book);
            }
        }
    }

    public void borrowBook(Book book) {
        if (books != null && book != null) {
            if (books.contains(book)) {
                books.remove(book);
                // Notify observer
                if (libraryObserver != null) {
                    libraryObserver.onBookBorrowed(book);
                }
            } else {
                // Notify observer
                if (libraryObserver != null) {
                    libraryObserver.onBookNotAvailable(book);
                }
            }
        }
    }

    public void returnBook(Book book) {
        if (books != null && book != null) {
            if (!books.contains(book)) {
                books.add(book);
                // Notify observer
                if (libraryObserver != null) {
                    libraryObserver.onBookReturned(book);
                }
            }
        }
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void addObserver(LibraryObserver libraryObserver) {
        this.libraryObserver = libraryObserver;
    }
}
