package com.grupp2.webservices.controller;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping()
    public List<User> listUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @DeleteMapping(path ="{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id")Long id, @RequestBody User user){
    userService.updateUser(id,user);
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }


}
