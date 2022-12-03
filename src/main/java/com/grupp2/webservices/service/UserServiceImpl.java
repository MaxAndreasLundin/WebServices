package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        if(userRepository.findAll().size()<=0){
            throw new UserNotFoundException("No users found");
        }
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        if ((id > findAllUsers().size()) || (id <= 0)) {
            throw new UserNotFoundException("id not found - " + id);
        }
        return userRepository.findById(id);
    }

    @Transactional
    public void updateUser(Long id, User user) {

        User userToUpdate = findUserById(id).orElseThrow(() -> new UserNotFoundException("id not found - " + id));

        if (user.getFirstname() != null) { userToUpdate.setFirstname(user.getFirstname()); }
        if (user.getLastname() != null) { userToUpdate.setLastname(user.getLastname()); }
        if (user.getEmail() != null) { userToUpdate.setEmail(user.getEmail()); }
        if (user.getPassword() != null) { userToUpdate.setPassword(user.getPassword()); }

        userRepository.save(userToUpdate);

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
