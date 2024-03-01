package com.example.pacbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.pacbackend.Users.User.User;
import com.example.pacbackend.Users.User.UserRepository;
import com.example.pacbackend.Users.User.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

  @Autowired
  UserRepository userRepository;
  @Autowired
  UserService userService;

  @Test
  public void getByEmailTest(){
    //Creo un utente e lo salvo
    String name = "Francesco";
    String lastName = "Rossi";
    String email = "francesco.rossi@gmail.com";
    String password = "passWord";

    User expected = new User(name, lastName, email, password);
    userRepository.save(expected);

    //Effettuo la ricerca 
    Optional<User> optionalResult = userService.getByEmail(email);
    //Controlla che ci sia un utente
    assertTrue(optionalResult.isPresent());
    User actual = optionalResult.get();
    //Controllo che sia l'utente giusto
    assertEquals(expected.getUserId(), actual.getUserId());

  }
  
}
