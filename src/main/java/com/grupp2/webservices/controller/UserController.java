package com.grupp2.webservices.controller;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping(path = "{personalId}")
    public Optional<User> findById(@PathVariable("personalId") Long personalId) {
        return userService.findById(personalId);
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @DeleteMapping(path = "{personalId}")
    public void deleteUser(@PathVariable("personalId") Long personalId) {
        userService.deleteUser(personalId);
    }

    @PutMapping("{personalId}")
    public void updateUser(@PathVariable("personalId") Long personalId, @RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) String email, @RequestParam(required = false) String password) {
        userService.updateUser(personalId, name, surname, email, password);
    }
}
