package com.example.pacbackend.Users.User;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService ordineService){
        this.userService=ordineService;
    }

        // ritorna la lista di tutti gli utenti
        @GetMapping("/getAllUsers")
        @ResponseBody
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }
        @GetMapping("/getUserById")
        @ResponseBody
        public Optional<User> getUserById(Long id){
            return userService.getById(id);
        }

        //TODO: Implementare carta fedeltà
        @GetMapping("/getUserByFidelity")
        @ResponseBody
        public Optional<User> getByFidelity(int fidelityCard){
            return userService.getByFidelity(fidelityCard);
        }

        @GetMapping("/getUserByEmail")
        @ResponseBody
        public Optional<User> getByEmail(String email){
            return userService.getByEmail(email);
        }

         //TODO: Implementare rating
        @GetMapping("/getUserByRating")
        @ResponseBody
        public List<User> getByRating(int rating){ 
            return userService.getByRating(rating);
        }

        @GetMapping("/getUserByRatingLessThan")
        @ResponseBody
        public List<User> getByRatingLessThan(Integer rating){ 
            return userService.getByRatingLessThan(rating);
        }

        @GetMapping("/getUserByRatingMoreThan")
        @ResponseBody
        public List<User> getByRatingGreaterThan(@RequestParam Integer rating){ 
            return userService.getByRatingGreaterThan(rating);
        }

        @DeleteMapping("/deleteUser")
        public void deleteById(@RequestParam long id){
            userService.deleteById(id);
        }
}
