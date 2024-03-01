package com.example.pacbackend.Registration;

import lombok.Getter;
import lombok.ToString;

/*
 * Questa classe definisce la struttura di quella che deve essere
 * una richiesta di registrazione
 */

 @Getter
 @ToString
public class RegistrationRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public RegistrationRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    
    
}
