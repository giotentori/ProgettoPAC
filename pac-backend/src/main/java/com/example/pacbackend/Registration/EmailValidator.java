package com.example.pacbackend.Registration;

import org.springframework.stereotype.Service;

//TODO: Aggiungere logica di controllo validità email

@Service
public class EmailValidator {
    public boolean isValid(String email) {
        return true;
    }
}
