package com.example.springtemplate.controller;

import com.example.springtemplate.controller.apimodel.UserId;
import com.example.springtemplate.data.entity.User;
import com.example.springtemplate.data.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser() {
        User user = new User("Filip", "Password");
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(200).body(createdUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<User> getAllUsers(
            @RequestBody UserId userId
    ) {
        System.out.println(userId);
        User user = userService.findUserById(UUID.fromString(userId.getUserId()));
        return ResponseEntity.status(200).body(user);
    }
}
