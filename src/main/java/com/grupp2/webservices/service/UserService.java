package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateUser(Long personalId, String name, String surname, String email, String password) {

        User user = userRepository.findById(personalId).orElseThrow(() -> new IllegalStateException("user with id " + personalId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if (surname != null && surname.length() > 0 && !Objects.equals(user.getSurname(), surname)) {
            user.setSurname(surname);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            user.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
    }
}
