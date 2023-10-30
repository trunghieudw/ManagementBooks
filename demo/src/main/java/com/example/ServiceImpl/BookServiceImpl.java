package com.example.ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

import java.util.List;

import com.example.DAO.*;
import com.example.Entities.*;
import com.example.Services.*;

public class BookServiceImpl extends UnicastRemoteObject implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(Connection connection) throws RemoteException {
        super();
        bookDAO = new BookDAO(connection);
    }

    @Override
    public boolean addBook(Book book) throws RemoteException {
        return bookDAO.addBook(book);
    }

    @Override
    public boolean removeBook(String bookId) throws RemoteException {
        return bookDAO.removeBook(bookId);
    }

    @Override
    public boolean updateBook(Book book) throws RemoteException {
        return bookDAO.updateBook(book);
    }

    @Override
    public Book getBook(String bookId) throws RemoteException {
        return bookDAO.getBook(bookId);
    }

    @Override
    public List<Book> getAllBooks() throws RemoteException {
        return bookDAO.getAllBooks();
    }

}
