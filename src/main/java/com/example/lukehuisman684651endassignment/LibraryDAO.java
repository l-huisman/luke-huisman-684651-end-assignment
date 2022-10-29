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

    // Method to get all library items from a csv file contain both movies and books
    public List<LibraryItem> getAllLibraryItems() {
        List<LibraryItem> libraryItems = new ArrayList<>();
        Path pathToFile = Paths.get(LIBRARYITEMSFILEPATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile.toFile()));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                if (attributes[0].equals("Book"))
                    libraryItems.add(createBook(attributes));
                if (attributes[0].equals("Movie"))
                    libraryItems.add(createMovie(attributes));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libraryItems;
    }

    private LibraryItem createMovie(String[] attributes) {
        return new Movie(Integer.parseInt(attributes[1]), attributes[2], Boolean.parseBoolean(attributes[3]), Integer.parseInt(attributes[4]), ifNullSetDateNow(attributes[5]), attributes[6]);
    }

    private LibraryItem createBook(String[] attributes) {
        return new Book(Integer.parseInt(attributes[1]), attributes[2], Boolean.parseBoolean(attributes[3]), Integer.parseInt(attributes[4]), ifNullSetDateNow(attributes[5]), attributes[6]);
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
        String itemType = "";
        String itemCode = "";
        String title = "";
        String isLent = "";
        String memberIdentifier = "";
        String dateLent = "";
        String author = "";
        String director = "";

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File(LIBRARYITEMSFILEPATH));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                itemType = x.next();
                itemCode = x.next();
                title = x.next();
                isLent = x.next();
                memberIdentifier = x.next();
                dateLent = x.next();
                if (itemType.equals("Book"))
                    author = x.next();
                if (itemType.equals("Movie"))
                    director = x.next();
                if (itemCode.equals(String.valueOf(libraryItem.getItemCode())) && !recordChanged && !Objects.equals(libraryItem.isLent(), Boolean.parseBoolean(isLent))) {
                    if (itemType.equals("Book"))
                        pw.print(itemType + "," + itemCode + "," + title + "," + libraryItem.isLent() + "," + libraryItem.getMemberIdentifier() + "," + libraryItem.getDateLent() + "," + author + "\n");
                    if (itemType.equals("Movie"))
                        pw.print(itemType + "," + itemCode + "," + title + "," + libraryItem.isLent() + "," + libraryItem.getMemberIdentifier() + "," + libraryItem.getDateLent() + "," + director + "\n");
                    recordChanged = true;
                    continue;
                }
                if (itemType.equals("Book"))
                    pw.print(itemType + "," + itemCode + "," + title + "," + isLent + "," + memberIdentifier + "," + dateLent + "," + author + "\n");
                if (itemType.equals("Movie"))
                    pw.print(itemType + "," + itemCode + "," + title + "," + isLent + "," + memberIdentifier + "," + dateLent + "," + director + "\n");
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
        List<LibraryItem> libraryItems = getAllLibraryItems();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemCode() == itemCode && !libraryItem.isLent())
                return libraryItem;
        }
        return null;
    }

    public LibraryItem getLentLibraryItem(int itemCode, int memberIdentifier) {
        List<LibraryItem> libraryItems = getAllLibraryItems();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemCode() == itemCode && libraryItem.isLent() && libraryItem.getMemberIdentifier() == memberIdentifier)
                return libraryItem;
        }
        return null;
    }
}
