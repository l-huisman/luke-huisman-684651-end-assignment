package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;

public class LibraryItem {
    private int itemCode;
    private String title;
    private boolean availability;
    private int memberIdentifier;
    private LocalDate dateLent;
    private String author;

    public LibraryItem(int itemCode, String title, boolean availability, int memberIdentifier, LocalDate dateLent, String author) {
        this.itemCode = itemCode;
        this.title = title;
        this.availability = availability;
        this.memberIdentifier = memberIdentifier;
        this.dateLent = dateLent;
        this.author = author;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getMemberIdentifier() {
        return memberIdentifier;
    }

    public void setMemberIdentifier(int memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public void setDateLent(LocalDate dateLent) {
        this.dateLent = dateLent;
    }
}
