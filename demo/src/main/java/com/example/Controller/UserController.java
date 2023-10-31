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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() throws RemoteException {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) throws RemoteException {
        boolean isAdded = userService.addUser(user);
        if (isAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add user.");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> removeUser(@PathVariable String userId) throws RemoteException {
        boolean isRemoved = userService.removeUser(userId);
        if (isRemoved) {
            return ResponseEntity.status(HttpStatus.OK).body("User removed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or failed to remove.");
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable String userId, @RequestBody User updatedUser) throws RemoteException {
        boolean isUpdated = userService.updateUser(updatedUser);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or failed to update.");
        }
    }
}

