package com.foursys.fourcamp.alphabank.service;


import com.foursys.fourcamp.alphabank.entities.Role;
import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.RoleRepository;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public User create(User user){
        Long id = 1L;
        Role role = roleRepository.findById(id).get();
        user.getRoles().add(role);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       return  userRepository.save(user);
    }
}
