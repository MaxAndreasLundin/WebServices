package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long personalId) {
        return userRepository.findById(personalId);
    }


    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long personalId) {
        boolean exists = userRepository.existsById(personalId);
        if (!exists) {
            throw new IllegalStateException("User with id " + personalId + " does not exists");
        }
        userRepository.deleteById(personalId);
    }
}
