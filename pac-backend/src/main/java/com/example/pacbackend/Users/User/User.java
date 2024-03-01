package com.example.pacbackend.Users.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pacbackend.Notebook.Notebook;
import com.example.pacbackend.Users.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


/**
 * Classe per la rappresentazione del cliente
 * @author Gamba Davide
 */

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private long userId;
    private int rating;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Transient                            //Campo non specificato nel DB
    private Role userRole = Role.USER;
    private int fidelityCard;

    private Boolean locked = false;
    private Boolean enabled = true;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteComp")
    // private List<Ordine> ordiniEffettuati; // lista degli ordini effettuati da un utente 
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteVend")
    // private List<Ordine> ordiniRicevuti; // lista degli ordini ricevuti da un utente ( che quell'utente ha fornito )

    @OneToMany
    private List<Notebook> prodottiInVendita;

    public User() {
        
    }

    public User(long id) {
        this.userId=id;
    }

    public User(String firstName, String lastName, String email, String password) {
    
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rating = 0; // inizialmente a 0
        // this.ordiniEffettuati=null;
        // this.ordiniRicevuti=null;
    
}
     /*
     * Restituisce le autorizzazioni concesse all'utente. Non può restituire null.
     */ 

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    public long getUserId(){
        return userId;
    }
    public void setUserId(long id){
        userId=id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getFidelityPoints() {
        return this.fidelityCard;
    }

    public void updateFidelityPoints(int fidelityPoints) {
        this.fidelityCard = fidelityPoints;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int ordineRating) {
        this.rating += ordineRating;
    }

    public int getFidelityCard() {
        return fidelityCard;
    }

    public List<Notebook> getProdottiInVendita(){
        return prodottiInVendita;
    }


}
