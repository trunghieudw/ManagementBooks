package com.example.Services;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
@Service

public interface ManagementService extends Remote {
    LibraryService getLibraryService() throws RemoteException;
    UserService getUserService() throws RemoteException;
    BookService getBookService() throws RemoteException;
}
