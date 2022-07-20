package com.foursys.fourcamp.alphabank.config;

import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockAdmin implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User adm = new User(null ,"adm", "adm", "$2a$12$WZWz7pqNiVWX5VVJKC4u0uTYmSRnnfoxHRHubOeX316/IhroXn/EW");
        userRepository.save(adm);
    }
}
