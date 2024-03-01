package com.example.pacbackend.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pacbackend.Users.User.User;

/**
 * interfaccia Repository della login page
 * @author Tentori Giorgio
 */

public interface LoginRepository extends JpaRepository<User,Long> {
    
    @Query("SELECT u.password FROM User u WHERE u.email = ?1")
    String findPasswordByUsername(String username);

}
