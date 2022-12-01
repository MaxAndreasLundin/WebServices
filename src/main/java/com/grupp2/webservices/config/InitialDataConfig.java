package com.grupp2.webservices.config;

import com.grupp2.webservices.entity.User;
import com.grupp2.webservices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitialDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User user1 = new User("Benni", "Beany", "deezbeenz@mail.com", "password");
            User user2 = new User("Arne", "Weise", "arne@mail.com", "password");
            userRepository.saveAll(List.of(user1,user2));
        };
    }
}
