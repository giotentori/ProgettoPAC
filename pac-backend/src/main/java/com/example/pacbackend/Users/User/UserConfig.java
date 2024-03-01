package com.example.pacbackend.Users.User;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
            return args -> {
              User davide= new User("Davide","Gamba","d.gamba@gmail.com","password");
              User giorgio= new User("Giorgio","Tentori","giorgio","1");
              User aurora= new User("Aurora","Zanenga","a.zanenga@gmail.com","password");

              aurora.setRating(9);
              giorgio.setRating(10);
              davide.setRating(8);

            repository.saveAll(List.of(davide,giorgio,aurora));
            };
        }
    
}
