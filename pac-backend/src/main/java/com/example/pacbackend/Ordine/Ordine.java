package com.example.pacbackend.Ordine;

import java.util.List;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Users.User.User;

import jakarta.persistence.*;

@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @SequenceGenerator(
        name = "ordine_sequence",
        sequenceName="ordine_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator="Ordine_sequence"
    )
    private long id;

    private User utenteComp;        // utente che effettua l'ordine
    private User utenteVend;        // utente da cui si effettua l'ordine

    private float ordRating;        // rating dell'ordine la cui media degli altri ordini da il rating dell'utente

    @Column(name = "id_prodotto")
    private int idProduct;      //prodotto ordinato

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    // private List<Notebook> products;    //Notebooks dell'ordine

    public Ordine(long id, User utenteComp, User utenteVend){ // come argomento ho anche l'utente che ha fatto l'ordine 
        this.id=id;
        this.utenteComp = utenteComp;
        this.utenteVend = utenteVend;
        this.ordRating = 0; // inizialmente il rating è nullo

    }

    public Ordine(User utenteComp, User utenteVend, int idProduct ){ // come argomento ho anche la lista di notebooks
        this.utenteComp = utenteComp;
        this.utenteVend = utenteVend;
        this.ordRating = 0;         // inizialmente il rating è nullo
        this.idProduct = idProduct;
    }

    public Ordine(){

    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public User getUtenteComp() {
        return utenteComp;
    }
    public User getUtenteVend() {
        return utenteVend;
    }
    public float getOrdRating() {
        return ordRating;
    }
    public void setOrdRating(int ordRating) {
        this.ordRating = ordRating;
    }
    // public List<Notebook> getProducts() {
    //     return products;
    // }
    // public void setProducts(List<Notebook> products) {
    //     this.products = products;
    // }

}
