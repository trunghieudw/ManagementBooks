package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LibraryService extends Remote {
    List<Book> getAllBooks() throws RemoteException;
    void borrowBook(String userId, String bookId) throws RemoteException;
    void returnBook(String userId, String bookId) throws RemoteException;
}
