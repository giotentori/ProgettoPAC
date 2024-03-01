package com.example.pacbackend.Carrello;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pacbackend.Notebook.Notebook;

@Controller
public class CarrelloController {
    
        private final CarrelloService carrelloService;

    public CarrelloController(CarrelloService carrelloService){
        this.carrelloService=carrelloService;
    }

    @GetMapping("/restricted/userPage/carrello/TuttiArticoli")
    @ResponseBody
    public List<Notebook> tuttiArticoli(){
        return carrelloService.tuttiArticoli();
    }

    @GetMapping("/restricted/userPage/carrello/TrovaArticolo")
    @ResponseBody
    public Notebook trovaArticolo(long id){
        return carrelloService.trovaArticolo(id);
    }

}
