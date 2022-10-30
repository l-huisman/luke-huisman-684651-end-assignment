package com.example.lukehuisman684651endassignment;

import java.time.LocalDate;
import java.util.List;

public class LibraryService {
    LibraryDAO libraryDAO = new LibraryDAO();

    public String lendLibraryItem(int itemCode, int memberIdentifier) {
        // This method checks if the item is available to lend and then lends it to the member
        LibraryItem libraryItem = libraryDAO.getAvailableLibraryItem(itemCode);
        if (libraryItem != null) {
            libraryItem.setAvailability(false);
            libraryItem.setMemberIdentifier(memberIdentifier);
            libraryDAO.editLibraryItemInFile(libraryItem);
            return "Item is lent";
        }
        return "Item is not available";
    }

    public String receiveLibraryItem(int itemCode, int memberIdentifier) {
        // This method checks if the item is lent to the member and if it is too late then receives it
        String message = "Item wasn't lent by member: " + memberIdentifier;
        LibraryItem libraryItem = libraryDAO.getLentLibraryItem(itemCode, memberIdentifier);
        if (libraryItem != null) {
            int daysTooLate = getDaysTooLate(libraryItem);
            if (daysTooLate > 0)
                message = "Item is (" + daysTooLate + ") days too late!";
            else
                message = "Item is received!";
            libraryItem.setAvailability(true);
            libraryItem.setMemberIdentifier(0);
            libraryItem.setDateLent(null);
            libraryDAO.editLibraryItemInFile(libraryItem);
        }
        return message;
    }

    public int getDaysTooLate(LibraryItem libraryItem) {
        int daysTooLate = 0;
        if (libraryItem.getDateLent().plusDays(21).isBefore(LocalDate.now()))
            daysTooLate = LocalDate.now().getDayOfYear() - libraryItem.getDateLent().plusDays(21).getDayOfYear();
        return daysTooLate;
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryDAO.getLibraryItems();
    }
}
