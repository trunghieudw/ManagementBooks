package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface UserService extends Remote {
    boolean addUser(User user) throws RemoteException;

    boolean removeUser(String userId) throws RemoteException;

    boolean updateUser(User user) throws RemoteException;

    User getUser(String userId) throws RemoteException;

    List<User> getAllUsers() throws RemoteException;

}
