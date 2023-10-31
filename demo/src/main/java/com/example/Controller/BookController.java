package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entities.*;
import com.example.Services.*;

import java.rmi.RemoteException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() throws RemoteException {
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody Book book) throws RemoteException {
        boolean isAdded = bookService.addBook(book);
        if (isAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add book.");
        }
    }

    @DeleteMapping("/{bookId}")
    public boolean removeBook(@PathVariable String bookId) throws RemoteException {
        // Gọi dịch vụ RMI để xoá sách
        return bookService.removeBook(bookId);
    }

    @PutMapping("/{bookId}")
    public boolean updateBook(@PathVariable String bookId, @RequestBody Book updatedBook) throws RemoteException {
        // Gọi dịch vụ RMI để cập nhật sách
        return bookService.updateBook(updatedBook);
    }
}
