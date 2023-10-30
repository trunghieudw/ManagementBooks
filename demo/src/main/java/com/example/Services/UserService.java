package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    boolean addUser(User user) throws RemoteException;
    boolean removeUser(String userId) throws RemoteException;
    boolean updateUser(User user) throws RemoteException;
    User getUser(String userId) throws RemoteException;
}
