package org.example.wl2.controller;

import org.example.wl2.model.UserModel;
import org.example.wl2.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;

    }

   @PostMapping("/register")
    public String register (@ModelAttribute UserModel user){
            service.registerUser(user);
            return "redirect:/login";
   }

   @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password, HttpSession session){
        boolean success = service.login(username,password);
        if (success){
            var user = service.getUsername(username);
            session.setAttribute("userId",user.getId());
            return "redirect:/wishes";
        } else {
            return "redirect:/login?error=true";
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
