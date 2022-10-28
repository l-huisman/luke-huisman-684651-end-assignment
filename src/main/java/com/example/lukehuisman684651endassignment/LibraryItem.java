package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;

public abstract class LibraryItem {
    private int itemCode;
    private String title;
    private boolean isLent;
    private int memberIdentifier;
    private LocalDate dateLent;

    protected LibraryItem(int itemCode, String title, boolean isLent, int memberIdentifier, LocalDate dateLent) {
        this.itemCode = itemCode;
        this.title = title;
        this.isLent = isLent;
        this.memberIdentifier = memberIdentifier;
        this.dateLent = dateLent;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLent() {
        return isLent;
    }

    public int getMemberIdentifier() {
        return memberIdentifier;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public void setLent(boolean isLent) {
        this.isLent = isLent;
    }

    public void setMemberIdentifier(int memberIdentifier) {
        this.memberIdentifier = memberIdentifier;
    }

    public void setDateLent(LocalDate dateLent) {
        this.dateLent = dateLent;
    }
}
