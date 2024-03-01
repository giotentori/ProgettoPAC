package com.example.pacbackend.Ordine;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.pacbackend.Users.User.User;

public interface OrdineRepository extends JpaRepository<Ordine,Long>{ 

    @Query("SELECT o from Ordine o where o.id = ?1") // business logic
    Optional<Ordine> findById(long id);

    @Query("SELECT o FROM Ordine o where o.utenteComp = ?1") // tutti gli ordini che un utente ha effettuato
    List<Ordine> findByUserComp(User utenteComp);
    @Query("SELECT o FROM Ordine o where o.utenteVend = ?1") // tutti gli ordini che che forniti questo utente
    List<Ordine> findByUserVend(User utenteVend);

    List<Ordine> findByOrdRating(int ordRating);
    List<Ordine> findByOrdRatingLessThan(int ordRating);

    @Query("SELECT o.utenteComp FROM Ordine o where o.id = ?1") // l'utente che ha effettuato l'ordine con questo id
    Optional<User> findUserCompByOrdineId(long id);

    @Query("SELECT o.utenteVend FROM Ordine o where o.id = ?1") // l'utente da cui è stato effettuato questo ordine 
    Optional<User> findUserVendByOrdineId(long id);

    void deleteById(long id);
    
    @Modifying
    @Query("UPDATE User u SET u.rating = ?1 WHERE u.userId = ?2")
    void setUserRating(float rating, long userId);
    
}
