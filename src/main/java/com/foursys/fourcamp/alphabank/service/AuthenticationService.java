package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.config.security.TokenService;
import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }


}
