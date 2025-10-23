package org.example.wl2.service;

import ch.qos.logback.core.model.Model;
import org.example.wl2.model.userModel;
import org.example.wl2.repository.userRepo;
import org.springframework.stereotype.Service;

@Service
public class userService {
    private final userRepo repository;

    public userService(userRepo repository){
        this.repository = repository;
    }

    public userModel getUserName(String user){
        return repository.findByUserName(user);

    }

    public userModel getEmail(String email){
        return repository.findByEmail(email);
    }

    public boolean confirmUser(String username, String password){
        return repository.validateUser(username,password);
    }

    public void saveUser(String user, userModel model){
       repository.save(model);
    }

}
