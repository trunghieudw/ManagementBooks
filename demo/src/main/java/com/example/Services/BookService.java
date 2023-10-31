package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface BookService extends Remote {
    List<Book> getAllBooks() throws RemoteException;

    boolean addBook(Book book) throws RemoteException;

    boolean removeBook(String book) throws RemoteException;

    boolean updateBook(Book book) throws RemoteException;

    Book getBook(String bookId) throws RemoteException;
}
