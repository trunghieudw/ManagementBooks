package com.example.ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.List;

import com.example.DAO.*;
import com.example.Entities.*;
import com.example.Services.*;

public class AuthorServiceImpl extends UnicastRemoteObject implements AuthorService {
    
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(Connection connection) throws RemoteException {
        super();
        authorDAO = new AuthorDAO(connection);
    }

    @Override
    public boolean addAuthor(Author author) throws RemoteException {
        return authorDAO.addAuthor(author);
    }

    @Override
    public boolean removeAuthor(String authorId) throws RemoteException {
        return authorDAO.removeAuthor(authorId);
    }

    @Override
    public boolean updateAuthor(Author author) throws RemoteException {
        return authorDAO.updateAuthor(author);
    }

    @Override
    public Author getAuthor(String authorId) throws RemoteException {
        return authorDAO.getAuthor(authorId);
    }

    @Override
    public List<Author> getAllAuthors() throws RemoteException {
        return authorDAO.getAllAuthors();
    }
}