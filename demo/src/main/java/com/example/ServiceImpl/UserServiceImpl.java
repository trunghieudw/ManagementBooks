package com.example.ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

import com.example.DAO.*;
import com.example.Entities.*;
import com.example.Services.*;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(Connection connection) throws RemoteException {
        super();
        userDAO = new UserDAO(connection);
    }

    @Override
    public boolean addUser(User user) throws RemoteException {
        return userDAO.addUser(user);
    }

    @Override
    public boolean removeUser(String userId) throws RemoteException {
        return userDAO.removeUser(userId);
    }

    @Override
    public boolean updateUser(User user) throws RemoteException {
        return userDAO.updateUser(user);
    }

    @Override
    public User getUser(String userId) throws RemoteException {
        return userDAO.getUser(userId);
    }
}
