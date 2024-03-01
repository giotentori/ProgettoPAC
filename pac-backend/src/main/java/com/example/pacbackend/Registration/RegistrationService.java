package com.example.pacbackend.Registration;

import org.springframework.stereotype.Service;

import com.example.pacbackend.Users.User.User;
import com.example.pacbackend.Users.User.UserService;

@Service
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final UserService userService;

    public RegistrationService(UserService appUserService,EmailValidator emailValidator) {
        this.userService = appUserService;
        this.emailValidator = emailValidator;
    }

    //Richiesta di registrazione del cliente
    public void registerUser(RegistrationRequest request) {
        if(!emailValidator.isValid(request.getEmail()))
        throw new IllegalStateException("Email inserita non è valida");
        //Salvo il nuovo cliente nel database clienti
        userService.signUpUser(new User(
        request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword()));
    }
    
    
}
