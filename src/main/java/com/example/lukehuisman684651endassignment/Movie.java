package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;

public class Movie extends LibraryItem {
    private String director;

    protected Movie(int itemCode, String title, boolean isLent, int memberIdentifier, LocalDate dateLent , String director) {
        super(itemCode, title, isLent, memberIdentifier, dateLent);
        this.director = director;
    }
}

