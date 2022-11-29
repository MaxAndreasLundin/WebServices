package com.grupp2.webservices.controller;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.service.UserErrorResponse;
import com.grupp2.webservices.service.UserNotFoundException;
import com.grupp2.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

private final UserService userService;

    @Autowired
    public UserController(UserService userService){
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

    /*@GetMapping(path = "{id}")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }*/

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
        if ((id>= listUsers().size()) || (id<0)){
            throw new UserNotFoundException("id not found - " + id);
        }
        return userService.findById(id);
    }



}
