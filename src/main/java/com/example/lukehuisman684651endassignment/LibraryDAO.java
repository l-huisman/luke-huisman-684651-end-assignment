package com.example.lukehuisman684651endassignment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LibraryDAO {
    private static final String LIBRARYITEMSFILEPATH = "src/main/resources/libraryitems.txt";

    // 1: Check if the itemCode is the same
    private static boolean hasEqualItemCode(LibraryItem libraryItem, String attribute) {
        return libraryItem.getItemCode() == Integer.parseInt(attribute);
    }

    // 3: Check if the availability is different, so we don't overwrite someone else's reservation
    private static boolean compareAvailability(LibraryItem libraryItem, String[] attributes) {
        return !Objects.equals(libraryItem.getAvailability(), Boolean.parseBoolean(attributes[3]));
    }

    // Method to get all library items from a csv file contain both movies and books
    public List<LibraryItem> getLibraryItems() {
        List<LibraryItem> libraryItems = new ArrayList<>();
        Path pathToFile = Paths.get(LIBRARYITEMSFILEPATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile.toFile()));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                libraryItems.add(createLibraryItem(attributes));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libraryItems;
    }

    private LibraryItem createLibraryItem(String[] attributes)
    {
        // Attributes 0: itemCode, 1:title, 2:availability, 3:memberIdentifier, 4:dateLent, 5:author
        return new LibraryItem(Integer.parseInt(attributes[0]), attributes[1], Boolean.parseBoolean(attributes[2]), Integer.parseInt(attributes[3]), ifNullSetDateNow(attributes[4]), attributes[5]);
    }

    private LocalDate ifNullSetDateNow(String attribute) {
        if (attribute.equals("null"))
            return LocalDate.now();
        return LocalDate.parse(attribute);
    }

    // Code to update the txt file containing all movies found here https://www.youtube.com/watch?v=TpyRKom0X_s
    public void editLibraryItemInFile(LibraryItem libraryItem) {
        boolean recordChanged = false;
        String tempFile = "src/main/resources/temp.txt";
        File oldFile = new File(LIBRARYITEMSFILEPATH);
        File newFile = new File(tempFile);
        String[] attributes = new String[7];
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File(LIBRARYITEMSFILEPATH));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                for (int i = 0; i < 6; i++) {
                    attributes[i] = x.next();
                }
                // Check for 3 parameters before changing the record to avoid changing the wrong record in the file
                // 1: Check if the itemCode is the same
                // 2: Check if a record during this while loop hasn't been changed yet
                // 3: Check if the availability is different, so we don't overwrite someone else's reservation
                if (hasEqualItemCode(libraryItem, attributes[0]) && !recordChanged && compareAvailability(libraryItem, attributes)) {
                    pw.print(libraryItem.getItemCode() + "," + libraryItem.getTitle() + "," + libraryItem.getAvailability() + "," + libraryItem.getMemberIdentifier() + "," + libraryItem.getDateLent() + "," + libraryItem.getAuthor() + "\n");
                    recordChanged = true;
                    continue;
                }
                pw.print(attributes[0] + "," + attributes[1] + "," + attributes[2] + "," + attributes[3] + "," + attributes[4] + "," + attributes[5] + "\n");
                // Attributes are as followed: 0: itemCode, 1:title, 2:availability, 3:memberIdentifier, 4:dateLent, 5:author
            }
            x.close();
            pw.flush();
            pw.close();
            Files.delete(oldFile.toPath());
            newFile.renameTo(new File(LIBRARYITEMSFILEPATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LibraryItem getAvailableLibraryItem(int itemCode) {
        List<LibraryItem> libraryItems = getLibraryItems();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemCode() == itemCode && libraryItem.getAvailability())
                return libraryItem;
        }
        return null;
    }

    public LibraryItem getLentLibraryItem(int itemCode, int memberIdentifier) {
        List<LibraryItem> libraryItems = getLibraryItems();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemCode() == itemCode && !libraryItem.getAvailability() && libraryItem.getMemberIdentifier() == memberIdentifier)
                return libraryItem;
        }
        return null;
    }
}
