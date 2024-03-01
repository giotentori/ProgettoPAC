package com.example.pacbackend.Carrello;

import java.util.List;

import com.example.pacbackend.Notebook.Notebook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Classe per la rappresentazione del carrello di un utente
 * @author Tentori Giorgio
 */

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @SequenceGenerator(
        name = "carrello_sequence",
        sequenceName = "carrello_sequence",
        allocationSize = 1
)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "carrello_sequence"
    )
    private long userId;

    @OneToMany
    List<Notebook> articoli;

    public Carrello() {
        
    }

    public Carrello(long id) {
        this.userId=id;
    }
    public Carrello(long id, List<Notebook> listaarticoli) {
        this.userId = id;
        this.articoli=listaarticoli;
    }

    public long getUserId(){
        return userId;
    }
    public void setUserId(long id){
        userId=id;
    }
    public List<Notebook> getArticoli(){
        return articoli;
    }

}
