package com.example.pacbackend.Login;

import org.springframework.stereotype.Service;


/**
 * Classe Service della login page
 * @author Tentori Giorgio
 */

@Service
public class LoginService {
        private final LoginRepository loginRepository;
    
    // @Autowired
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public String getPasswordByUsername(String username){
        return loginRepository.findPasswordByUsername(username);
    }

}
