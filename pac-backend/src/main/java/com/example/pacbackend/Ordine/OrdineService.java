package com.example.pacbackend.Ordine;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pacbackend.Users.User.User;

@Service
public class OrdineService {
    private final OrdineRepository ordineRepository;
    
    // @Autowired
    public OrdineService(OrdineRepository ordineRepository){
        this.ordineRepository = ordineRepository;
    }
    
    // ritorna la lista di tutti gli ordini
    public List<Ordine> getAllOrdini(){
        return ordineRepository.findAll();
    }

    public Optional<Ordine> getOrdine(long id){
        return ordineRepository.findById(id);
    }

    // ritorna la lista di ordini effettuati da un determinato utente
    public List<Ordine> getOrdineByUserComp(User utenteComp){
        return ordineRepository.findByUserComp(utenteComp);
    }

    public List<Ordine> getOrdineByUserVend(User utenteVend){
        return ordineRepository.findByUserVend(utenteVend);
    }

    public List<Ordine> getOrdineByOrdRating(int ordRating){
        return ordineRepository.findByOrdRating(ordRating);
    }

    public List<Ordine> getOrdineByOrdRatingLessThan(int ordRating){
        return ordineRepository.findByOrdRatingLessThan(ordRating);
    }

    public Optional<User> getUtenteCompByOrdineId(long utenteCompId){
        return ordineRepository.findUserCompByOrdineId(utenteCompId);
    }
    
    public Optional<User> getUtenteVendByOrdineId(long utenteVendId){
        return ordineRepository.findUserVendByOrdineId(utenteVendId);
    }

    // crea un nuovo ordine e lo salva nel database
    public Ordine create(Ordine o) {
        Ordine newOrdine = new Ordine(o.getId(), o.getUtenteComp(), o.getUtenteVend());
        return ordineRepository.save(newOrdine);
    } 

    public void deleteOrdineById(long id){
        ordineRepository.deleteById(id);
    }

    public void mediaRatingUtente(User utente) throws Exception{
        List<Ordine> l = ordineRepository.findByUserVend(utente);
        int somma = 0;
        float media = 0;
        for (Ordine ordine : l) {
            somma += ordine.getOrdRating();
        }
        if(l.size() == 0) throw new Exception(" divisione per zero ");
        media = somma/l.size();

        ordineRepository.setUserRating(media, utente.getUserId());    
    }
    
}
