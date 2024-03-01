package com.example.pacbackend.Carrello;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pacbackend.Notebook.Notebook;

@Service
public class CarrelloService {
    
    private final CarrelloRepo carrelloRepo;

    public CarrelloService(CarrelloRepo carrelloRepo){
        this.carrelloRepo=carrelloRepo;
    }

    public Notebook trovaArticolo(long id){
        return carrelloRepo.findNotebookById(id).get();
    }

    public List<Notebook> tuttiArticoli(){
        return carrelloRepo.findAll();
    }
}
