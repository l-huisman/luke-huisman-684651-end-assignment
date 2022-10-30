package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;

public abstract class LibraryItem {
    private int itemCode;
    private String title;
    private boolean availability;
    private int memberIdentifier;
    private LocalDate dateLent;

    protected LibraryItem(int itemCode, String title, boolean availability, int memberIdentifier, LocalDate dateLent) {
        this.itemCode = itemCode;
        this.title = title;
        this.availability = availability;
        this.memberIdentifier = memberIdentifier;
        this.dateLent = dateLent;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getTitle() {
        return title;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean isLent) {
        this.availability = isLent;
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
