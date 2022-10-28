package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;

public class Book extends LibraryItem {
    private String author;

    protected Book(int itemCode, String title, boolean isLent, int memberIdentifier, LocalDate dateLent, String author) {
        super(itemCode, title, isLent, memberIdentifier, dateLent);
        this.author = author;
    }
}
