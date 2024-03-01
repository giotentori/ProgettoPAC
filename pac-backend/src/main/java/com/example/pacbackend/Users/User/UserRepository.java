package com.example.pacbackend.Users.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(User user);
    List<User> findByRating(int rating);
    Optional<User> findByFidelityCard(int fidelityCard);
    List<User> findByRatingLessThan(int rating);
    List<User> findByRatingGreaterThan(int rating);
    
    void deleteByUserId(long userId);

}
