package com.grupp2.webservices.controller;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.exception.ResourceNotFoundException;
import com.grupp2.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
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
    public ResponseEntity<User> updateUser(@PathVariable ("personalId") Long personalId, @RequestBody User userDetails) {
        User updateUser = userService.findById(personalId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + personalId));

        updateUser.setName(userDetails.getName());
        updateUser.setSurname(userDetails.getSurname());
        updateUser.setEmail(userDetails.getEmail());

        userService.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }
}
