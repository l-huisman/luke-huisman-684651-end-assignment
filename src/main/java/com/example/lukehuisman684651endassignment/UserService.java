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
        user.setPassword(setStandardPassword(user));
        userDAO.addUser(user);
    }

    public void editUser(User user) {
        userDAO.editUser(user);
    }

    private String setStandardPassword(User user) {
        String lastname = deleteSpaces(user.getLastName());
        return user.getFirstName().substring(0, 1) + lastname + user.getBirthDate().getYear() + "!";
    }

    private String deleteSpaces(String lastName) {
        return lastName.replace(" ", "");
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
}
