package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface LibraryService extends Remote {
    List<Book> getAllBooks() throws RemoteException;

    void borrowBook(String userId, String bookId) throws RemoteException;

    void returnBook(String userId, String bookId) throws RemoteException;
}
