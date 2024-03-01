package com.example.pacbackend.Notebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.pacbackend.Notebook.Technical_Features.Disk;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;
import com.example.pacbackend.Photo.Image;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;



@Configuration
public class NotebookConfig {
    @Bean
    CommandLineRunner commandLineRunnerNotebook(NotebookRepository notebookRepository) {
        return args -> {
                        

            Notebook apple1 = new Notebook("Macboook Pro M1", 13, OperatingSystem.MACOS,
                             "APPLE",8,512,Disk.SSD,"Chip M1","APPLE","Apple Silicon m1 2021",1200);
            
            Notebook lenovo1 = new Notebook("Lenovo Thinkpad",15,OperatingSystem.WINDOWS,
                             "LENOVO",16,1000,Disk.SSD,"Intel I5","NVIDIA","Lenovo ThinkPad",1300);
            
            Notebook asus1 = new Notebook("Asus F564GTHS", 17, OperatingSystem.WINDOWS, 
                            "ASUS", 8, 1000,Disk.HDD, "Intel I7", "NVIDIA", "Asus usato pochissimo", 900);
        
            
            /*Immagine 1 Macbook */
             Image macbookM1Image = new Image();      //Uso costruttore vuoto
             macbookM1Image.setFileName("MacbookM1-image.png");
             macbookM1Image.setMimeType("image/png");
             macbookM1Image.setData(Files.readAllBytes(Paths.get("/Users/davidegamba/Documents/GitHub/Pogetto_Pac-Zanenga_Tentori_Gamba/pac-backend/images-notebook/MacbookM1-image.png")));
             macbookM1Image.setUriImage("http://localhost:8080/images/MacbookM1-image.png");

            /*Immagine Lenovo */
             Image lenovo = new Image();
             lenovo.setFileName("lenovo1.png");
             lenovo.setMimeType("image/png");
             lenovo.setData(Files.readAllBytes(Paths.get("/Users/davidegamba/Documents/GitHub/Pogetto_Pac-Zanenga_Tentori_Gamba/pac-backend/images-notebook/lenovo.png")));
             lenovo.setUriImage("http://localhost:8080/images/lenovo1.png");

            /*Immagine HP */
             Image asus = new Image();
             asus.setFileName("asus.png");
             asus.setMimeType("image/png");
             asus.setData(Files.readAllBytes(Paths.get("/Users/davidegamba/Documents/GitHub/Pogetto_Pac-Zanenga_Tentori_Gamba/pac-backend/images-notebook/asus.png")));
             asus.setUriImage("http://localhost:8080/images/asus.png");

             apple1.setImage(macbookM1Image);
             lenovo1.setImage(lenovo);
             asus1.setImage(asus);



            notebookRepository.save(apple1);
            notebookRepository.save(lenovo1);
            notebookRepository.save(asus1);
        };
    }
    
}
