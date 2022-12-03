package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    void updateUser(Long id, User user);

    User createNewUser(User user);

    void deleteUserById(Long id);


}
