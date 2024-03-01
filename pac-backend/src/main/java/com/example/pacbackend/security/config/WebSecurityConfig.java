package com.example.pacbackend.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.pacbackend.Users.User.UserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
     * Permetto di bypassare la login solo per delle richieste http particolari
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /* 
        .authorizeHttpRequests()
                    //Definisco quali percorsi non necessitano dell'autenticazione
                    .requestMatchers("/" ,"/home", "/vestito/**","/maglietta/**",
                    "/registration/**","/loginProva","/notebook/**")          
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin().permitAll()           //Definisco la pagina di Login
                    .and()
                    .logout().permitAll();
        
                    */

        return http.build();
    }


    protected void configureUser(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationUser());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationUser() {
        //Gestione della Login per il cliente
        DaoAuthenticationProvider userProvider = new DaoAuthenticationProvider();
        userProvider.setPasswordEncoder(bCryptPasswordEncoder);
        userProvider.setUserDetailsService(userService);
        return userProvider;
    }
    
}
