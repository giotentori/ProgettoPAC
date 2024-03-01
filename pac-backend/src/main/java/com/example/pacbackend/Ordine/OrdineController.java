package com.example.pacbackend.Ordine;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacbackend.Users.User.User;

@RestController
@RequestMapping("api/ordine")
public class OrdineController {
    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService){
        this.ordineService=ordineService;
    }

        // ritorna la lista di tutti gli ordini
        @GetMapping("/getAllOrdini")
        @ResponseBody
        public List<Ordine> getAllOrdini(){
            return ordineService.getAllOrdini();
        }
        @GetMapping("/getOrdine")
        @ResponseBody
        public Optional<Ordine> getOrdine(Long id){
            return ordineService.getOrdine(id);
        }
    
        // ritorna la lista di ordini effettuati da un determinato utente
        @GetMapping("/getOrdineByUserComp")
        @ResponseBody
        public List<Ordine> getOrdineByUser(User utenteComp){
            return ordineService.getOrdineByUserComp(utenteComp);
        }

             // ritorna la lista di ordini effettuati da un determinato utente
        @GetMapping("/getOrdineByUserVend")
        @ResponseBody
        public List<Ordine> getOrdineByUserVend(User utenteVend){
            return ordineService.getOrdineByUserVend(utenteVend);
        }   

        @GetMapping("/getOrdineByRating")
        @ResponseBody
        public List<Ordine> getOrdineByRating(int ordRating){
            return ordineService.getOrdineByOrdRating(ordRating);
        }

        @GetMapping("/getOrdineByRatingLessThan")
        @ResponseBody
        public List<Ordine> getOrdineByOrdRatingLessThan(int ordRating){
            return ordineService.getOrdineByOrdRatingLessThan(ordRating);
        }
        @GetMapping("/getUtenteCompByOrdineId")
        @ResponseBody
        public Optional<User> getUtenteCompByOrdineId(long utenteCompId){
            return ordineService.getUtenteCompByOrdineId(utenteCompId);
        }
        @GetMapping("/getUtenteVendByOrdineId")
        @ResponseBody
        public Optional<User> getUtenteVendByOrdineId(long utenteVendId){
            return ordineService.getUtenteVendByOrdineId(utenteVendId);
        } 

        @PostMapping("/createNewOrdine")
        public Ordine create(@RequestBody Ordine o) {
            return this.ordineService.create(o);
        }

        @DeleteMapping("/deleteOrdine")
        public void deleteOrdineById(long id){
            this.ordineService.deleteOrdineById(id);
        }
        
        @PutMapping("/setRating")
        public void mediaRatingUtente(@RequestBody User utente) throws Exception{
            ordineService.mediaRatingUtente(utente);
        }
}
