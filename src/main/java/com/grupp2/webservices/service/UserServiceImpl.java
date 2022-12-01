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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        if ((id >= findAllUsers().size()) || (id <= 0)) {
            throw new UserNotFoundException("id not found - " + id);
        }
        return userRepository.findById(id);
    }

    public void updateUser(Long id, String name) {
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserNotFoundException("id not found - " + id);
        }
    }
}
