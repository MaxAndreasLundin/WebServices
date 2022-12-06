package com.grupp2.webservices.service;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends User{
    private final UserRepository userRepository;

    @Autowired
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createNewUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id){
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUserById (Long id, User user) {
        User userToUpdate = findById(id).orElseThrow(() -> new IllegalStateException("user not found " + id));

        if (user.getName() != null) {userToUpdate.setName(user.getName()); }
        if (user.getSurname() != null) {userToUpdate.setSurname(user.getSurname()); }
        if (user.getEmail() != null) {userToUpdate.setEmail(user.getEmail()); }
        if (user.getPassword() != null) {userToUpdate.setPassword(user.getPassword()); }

        userRepository.save(userToUpdate);
    }
}
