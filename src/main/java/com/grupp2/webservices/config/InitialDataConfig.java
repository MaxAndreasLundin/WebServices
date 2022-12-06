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
            User user1 = new User("Gabby", "Hede", "g@hotmail.com", "password");
            User user2 = new User("Peter", "pan", "pan@pmail.neverland", "passworet");

            userRepository.saveAll(List.of(user1, user2));
        };
    }
}
