package com.foursys.fourcamp.alphabank.config;

import com.foursys.fourcamp.alphabank.entities.Role;
import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.RoleRepository;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockAdmin implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        User adm = new User(null ,"adm","000.000.000-00","$2a$12$WZWz7pqNiVWX5VVJKC4u0uTYmSRnnfoxHRHubOeX316/IhroXn/EW");
        userRepository.save(adm);

        Role role = new Role("USER");
        roleRepository.save(role);

        Role admRole = new Role("ADMIN");
        roleRepository.save(admRole);

        adm.getRoles().add(admRole);
        userRepository.save(adm);
    }
}
