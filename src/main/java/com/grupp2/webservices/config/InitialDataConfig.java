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
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User arne = new User(198905083612L, "Arne", "Andersson", "arne@hotmail.com", "password");
            User kalle = new User(197003056513L, "Kalle", "Karlsson", "kalle@gmail.com", "123");

            userRepository.saveAll(List.of(arne, kalle));
        };
    }
}
