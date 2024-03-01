package com.example.pacbackend.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pacbackend.Users.User.UserService;


/**
 * Classe controller della login page
 * Login sviluppata con un metodo che sfrutta le variabili booleane
 * @author Tentori Giorgio
 */

@Controller
public class LoginController {
    
    private boolean block = false;
    private final LoginService loginService;
    
    // @Autowired
    public LoginController(LoginService loginService,UserService userService){
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String home1(){
        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }    

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        String passwordDb = loginService.getPasswordByUsername(username);

        if(username.equals("") || password.equals("") || !passwordDb.equals(password)){
            block = false;
            return "redirect:/error";

        }else{
            block = true;
            return "redirect:/restricted";
        }     
    }
        
    @GetMapping("/restricted")
    private String restrictedPage(){
        if(block == true){
           return "restricted"; 
        }
        else {
            block = false;
            return "redirect:/login";
        }
        
    }

    @GetMapping("/restricted/userPage")
    public String userPage(){
        if(block == true){
            return "userPage"; 
        }
        return "redirect:/login";
    }

    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }

    @GetMapping("/restricted/userPage/carrello")
    public String carrello(){
        return "carrello";
    }

}
