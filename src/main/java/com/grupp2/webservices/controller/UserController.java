package com.grupp2.webservices.controller;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
}

    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @DeleteMapping(path ="{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    //@PutMapping
    @PatchMapping
    public User updateUser(@RequestBody User theUser){
        userService.createNewUser(theUser);
        return theUser;
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }



}
