package com.example.demo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.com.example.ServiceImpl.BookServiceImpl;
import main.java.com.example.ServiceImpl.UserServiceImpl;
import main.java.com.example.Services.BookService;
import main.java.com.example.Services.UserService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		try {
            // imple file Database Connnection vào RMIServer
            Connection connection = DatabaseConnection.getConnection();


            // Tạo và đăng ký dịch vụ Book Service
            BookService bookService = new BookServiceImpl(connection);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BookService", bookService);

            // Tạo và đăng ký dịch vụ User Service
            UserService userService = new UserServiceImpl(connection);
            registry.rebind("UserService", userService);

            // Tạo và đăng ký dịch vụ Author Service
            AuthorService authorService = new AuthorServiceImpl(connection);
            registry.rebind("AuthorService", authorService);

            System.out.println("Tat ca dich vu dang chay");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
	}

}
