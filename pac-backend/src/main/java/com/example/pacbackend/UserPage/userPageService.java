package com.example.pacbackend.UserPage;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Ordine.Ordine;
import com.example.pacbackend.Users.User.User;

//Riga di prova per forzare github

/**
 * Classe Service della pagina personale utente
 * @author Tentori Giorgio
*/

@Service
public class UserPageService {
    
    private final UserPageRepository userPageRepository;

    // @Autowired
    public UserPageService(UserPageRepository userPageRepository){
        this.userPageRepository = userPageRepository;
    }

    List<Ordine> ordiniEffettuati(User utenteComp){
        return userPageRepository.findOrdiniEffByUser(utenteComp);
    }

    List<Notebook> prodottiInVendita(User utente){
        return userPageRepository.findProdottiInVenditaByUser(utente);
    }
    
    
}