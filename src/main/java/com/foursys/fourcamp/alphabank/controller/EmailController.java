package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.EmailDTO;
import com.foursys.fourcamp.alphabank.dto.PasswordRecoverDTO;
import com.foursys.fourcamp.alphabank.entities.Email;
import com.foursys.fourcamp.alphabank.entities.User;
import com.foursys.fourcamp.alphabank.repository.UserRepository;
import com.foursys.fourcamp.alphabank.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<Email>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable){
        return new ResponseEntity<>(emailService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity<Object> getOneEmail(@PathVariable(value="emailId") UUID emailId){
        Optional<Email> emailModelOptional = emailService.findById(emailId);
        return emailModelOptional.<ResponseEntity<Object>>map(email -> ResponseEntity.status(HttpStatus.OK).body(email))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found."));
    }

    @GetMapping("/recover-password")
    public ResponseEntity<Email> recoverPassword(@RequestBody PasswordRecoverDTO passwordRecoverDTO) {
        Email email = new Email();
        User user = userRepository.findByEmail(passwordRecoverDTO.getEmail()).get();
        email.setOwnerRef("A nova senha do Alpha Bank chegou!!");
        email.setEmailFrom("diogohvalent@gmail.com");
        email.setSubject("Recover Password");
        email.setText("Conforme solicitação, o AlphaBank criou uma nova senha temporária: " +
                " para você acessar suas informações \n"+ "Sua nova senha é: FOURSYS2022" );
        user.setPassword(new BCryptPasswordEncoder().encode("FOURSYS2022"));
        email.setEmailTo(user.getEmail());
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);

    }
}



