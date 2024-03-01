package com.example.pacbackend.UserPage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Ordine.Ordine;
import com.example.pacbackend.Users.User.User;

//Riga di prova

/**
 * Interfaccia repository della pagina personale utente
 * @author Tentori Giorgio
*/

public interface UserPageRepository extends JpaRepository<User, Long> {

    @Query("SELECT o FROM Ordine o where o.utenteComp = ?1")
    List<Ordine> findOrdiniEffByUser(User utenteComp);

    @Query("SELECT u.prodottiInVendita FROM User u WHERE u = ?1")
    List<Notebook> findProdottiInVenditaByUser(User user);
}
