package com.example.pacbackend.Users.User;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Individua l'utente in base all'username
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() 
        -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

     /*
     * Aggiungo un utente al database crittografando la password
     */
    public void signUpUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("Email already used");

        //Salvo utente nel database crittografando la passowrd
        String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getByFidelity(int fidelityCard){
        return userRepository.findByFidelityCard(fidelityCard);
    }

    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    // trova tutti gli utenti che hanno un certo rating
    public List<User> getByRating(int rating){
        return userRepository.findByRating(rating);
    }

    // trova tutti gli utenti che hanno rating inferiore a quello specificato
    public List<User> getByRatingLessThan(int rating){ 
        return userRepository.findByRatingLessThan(rating);
    }

    // trova tutti gli utenti che hanno rating superiore a quello specificato
    public List<User> getByRatingGreaterThan(int rating){ 
        return userRepository.findByRatingGreaterThan(rating);
    }


    // elimina un utente tramite l'id
    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    // crea un nuovo ordine e lo salva nel database
    public User create(User user) {
        User newUser = new User(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
        return userRepository.save(newUser);
    } 

}
