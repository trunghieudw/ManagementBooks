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
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() throws RemoteException {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public ResponseEntity<Object> addAuthor(@RequestBody Author author) throws RemoteException {
        boolean isAdded = authorService.addAuthor(author);
        if (isAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Author added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add author.");
        }
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Object> removeAuthor(@PathVariable String authorId) throws RemoteException {
        boolean isRemoved = authorService.removeAuthor(authorId);
        if (isRemoved) {
            return ResponseEntity.status(HttpStatus.OK).body("Author removed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found or failed to remove.");
        }
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Object> updateAuthor(@PathVariable String authorId, @RequestBody Author updatedAuthor) throws RemoteException {
        boolean isUpdated = authorService.updateAuthor(updatedAuthor);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Author updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found or failed to update.");
        }
    }
}
