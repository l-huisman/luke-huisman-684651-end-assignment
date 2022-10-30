package com.example.lukehuisman684651endassignment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    private static final String USERSFILEPATH = "src/main/resources/users.dataset";

    public User checkCredentialsOfEmployee(int userID, String password) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUserID() == userID && user.getPassword().equals(password) && user.getRole() == Role.EMPLOYEE)
                return user;
        }
        return null;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        if (!fileExists())
            createNewFile();
        Path pathToFile = Path.of(USERSFILEPATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile.toFile()));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                users.add(createUser(attributes));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private boolean fileExists()
    {
        return Path.of(USERSFILEPATH).toFile().exists();
    }

    private User createUser(String[] attributes) {
        // Attributes: 0: userID, 1: firstName, 2: lastName, 3: password, 4: birthDate, 5: role
        return new User(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3], LocalDate.parse(attributes[4]), Role.valueOf(attributes[5]));
    }

    public void addUser(User user) {
        if (!fileExists())
            createNewFile();
        if (userExists(user.getFirstName(), user.getLastName()))
            return;
        int nextAvailableUserID = getNextAvailableUserID();

        try {
            File file = new File(USERSFILEPATH);
            FileWriter fw = new FileWriter(file,true);
            fw.write("\n" + nextAvailableUserID + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getPassword() + "," + user.getBirthDate() + "," + user.getRole());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNextAvailableUserID() {
        List<User> users = getUsers();
        int highestUserID = 0;
        for (User user : users) {
            if (user.getUserID() > highestUserID)
                highestUserID = user.getUserID();
        }
        return highestUserID += 1;
    }

    private boolean userExists(String firstName, String lastName) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName))
                return true;
        }
        return false;
    }

    private void createNewFile() {
        try {
            //Create the file with one user
            File file = new File(USERSFILEPATH);
            FileWriter fw = new FileWriter(file);
            fw.write("1,Luke,Huisman,admin,2003-04-06,EMPLOYEE");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
