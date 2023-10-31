package com.example.Services;

import com.example.Entities.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface AuthorService extends Remote {
    List<Author> getAllAuthors() throws RemoteException;

    Author getAuthor(String authorId) throws RemoteException;

    boolean addAuthor(Author author) throws RemoteException;

    boolean updateAuthor(Author author) throws RemoteException;

    boolean removeAuthor(String authorId) throws RemoteException;
}
