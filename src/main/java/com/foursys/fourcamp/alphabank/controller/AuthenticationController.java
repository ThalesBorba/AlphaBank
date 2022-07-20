package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.config.security.TokenService;
import com.foursys.fourcamp.alphabank.dto.LoginDTO;
import com.foursys.fourcamp.alphabank.dto.TokenDTO;
import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = loginDTO.convert();
        try{
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(new TokenDTO(token , "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/findUserToken")
    public User recoverUserID(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String token2 = token.substring(7 , token.length());
        Long id = tokenService.getUserId(token2);
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok().body(user).getBody().orElseThrow(()-> new NoSuchElementException());
    }

}
