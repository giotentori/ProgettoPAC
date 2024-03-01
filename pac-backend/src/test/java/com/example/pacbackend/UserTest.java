package com.example.pacbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pacbackend.Users.User.User;

@SpringBootTest
public class UserTest {


  //Test per controllare che un utente venga creato correttamente
  @Test
  public void testCreateUser(){

    String name = "Francesco";
    String lastName = "Rossi";
    String email = "francesco.rossi@gmail.com";
    String password = "passWord";

    User user = new User(name, lastName, email, password);

    //Test sui campi
    assertEquals(name,user.getFirstName());
    assertEquals(lastName,user.getLastName());
    assertEquals(email,user.getEmail());
    assertEquals(password, user.getPassword());
    assertEquals(0,user.getRating());


  }
  
}
