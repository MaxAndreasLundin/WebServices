package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAllUsers();

    public Optional<User> findUserById(Long id);

    //public updateUser(Long id, String name);

    public User createNewUser(User user);

    public void deleteUserById(Long id);


}
