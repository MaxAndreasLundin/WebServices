package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getUsers();

    public User createNewUser(User user);

    public Optional<User> findById(Long id);

    public void deleteUserById(Long id);

    //public updateUser(Long id, String name);

}
