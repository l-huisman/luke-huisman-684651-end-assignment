package com.example.lukehuisman684651endassignment;

import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User checkCredentialsOfEmployee(int userID, String password) {
        return userDAO.checkCredentialsOfEmployee(userID, password);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
