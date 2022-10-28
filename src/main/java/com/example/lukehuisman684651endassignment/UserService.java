package com.example.lukehuisman684651endassignment;

public class UserService {
    UserDAO userDAO = new UserDAO();
    public User checkCredentialsOfEmployee(int userID, String password)
    {
        return userDAO.checkCredentialsOfEmployee(userID, password);
    }
}
