package org.example.wl2.controller;

import org.example.wl2.model.UserModel;
import org.example.wl2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;

    }

   @PostMapping("/register")
    public String register (@RequestBody UserModel user){
        try {
            service.registerUser(user);
            return "User registered";
        } catch (IllegalArgumentException e){
            return e.getMessage();
       }
   }

   @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String passwords){
        boolean sucess = service.login(username,passwords);
        if (sucess){
            return "Login succesful";
        } else {
            return "Invalid username or password";
        }
   }

   @GetMapping("/{username}")
    public UserModel getUser(@PathVariable String username){
        return service.getUsername(username);
   }

   @GetMapping("/email/{email}")
    public UserModel getUserByEmail(@PathVariable String email){
        return service.getEmail(email);
   }

}
