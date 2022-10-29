package com.example.lukehuisman684651endassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String USERSFILEPATH = "src/main/resources/users.txt";

    public User checkCredentialsOfEmployee(int userID, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getUserID() == userID && user.getPassword().equals(password) && user.getRole() == Role.EMPLOYEE)
                return user;
        }
        return null;
    }

    private List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
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

    private User createUser(String[] attributes) {
        return new User(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3], Role.valueOf(attributes[4]));
    }
}
