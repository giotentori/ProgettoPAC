package com.example.pacbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Notebook.NotebookRepository;
import com.example.pacbackend.Notebook.NotebookService;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;

@SpringBootTest
public class NotebookServiceTest {

  @Autowired
  NotebookRepository notebookRepository;
  @Autowired
  NotebookService notebookService;

  @Test
  public void findByOperatingSystemTest(){

    OperatingSystem windows = OperatingSystem.WINDOWS;
    OperatingSystem macos = OperatingSystem.MACOS;

    //Ritorna una lista di notebook con sistema operativo windows
    List<Notebook> listWindows = notebookRepository.findByOperatingSystem(windows);
    //Controllo che per ogni elemento restituito il sistema operativo sia windows
    for(Notebook notebook : listWindows){
      assertEquals(windows, notebook.getOperatingSystem());
    }

    //Ritorna una lista di notebook con sistema operativo windows
    List<Notebook> listMacos = notebookRepository.findByOperatingSystem(macos);
    //Controllo che per ogni elemento restituito il sistema operativo sia windows
    for(Notebook notebook : listMacos){
      assertEquals(macos, notebook.getOperatingSystem());
    }


  }
  
}
