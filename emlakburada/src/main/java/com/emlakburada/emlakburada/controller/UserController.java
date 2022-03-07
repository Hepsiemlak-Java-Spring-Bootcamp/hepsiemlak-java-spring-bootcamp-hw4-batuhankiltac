package com.emlakburada.emlakburada.controller;

import com.emlakburada.emlakburada.dto.request.UserRequest;
import com.emlakburada.emlakburada.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.add(userRequest));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping(value = "/users")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.update(userRequest));
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<?> deleteUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.delete(userRequest));
    }
}