package com.example.pacbackend.UserPage;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Ordine.Ordine;
import com.example.pacbackend.Users.User.User;

//Riga di prova


/**
 * Classe controller della pagina personale utente
 * @author Tentori Giorgio
*/

@Controller
public class UserPageController {

    private final UserPageService userPageService;

    // @Autowired
    public UserPageController(UserPageService userPageService){
        this.userPageService = userPageService;
    }

    @GetMapping("/restricted/userPage/ordiniEff")
    @ResponseBody
    List<Ordine> ordiniEffettuati(User utenteComp){
        return userPageService.ordiniEffettuati(utenteComp);
    }
    
    @GetMapping("/restricted/userPage/prodotti")
    @ResponseBody
    List<Notebook> prodottiInVendita(User utente){
        return userPageService.prodottiInVendita(utente);
    }

}
