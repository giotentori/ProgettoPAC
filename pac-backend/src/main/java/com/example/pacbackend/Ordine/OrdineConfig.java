package com.example.pacbackend.Ordine;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Notebook.Technical_Features.Disk;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;
import com.example.pacbackend.Users.User.User;

@Configuration
public class OrdineConfig {
    @Bean
    CommandLineRunner commandLineRunnerOrdine(OrdineRepository repository){
            return args -> {
          
           User davide= new User("Davide","Gamba","d.gamba@gmail.com","password");
           User giorgio= new User("Giorgio","Tentori","giorgio","1");

           Ordine ordine1 = new Ordine (davide, giorgio,100);
           Ordine ordine2 = new Ordine(giorgio,davide,200);

           ordine1.setOrdRating(5);
           ordine2.setOrdRating(4);

              
            repository.saveAll(List.of(ordine1,ordine2));
            };
        }
}
