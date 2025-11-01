package org.example.wl2.service;

import org.example.wl2.model.User;
import org.example.wl2.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo repository;

    public UserService(UserRepo repository){
        this.repository = repository;
    }

    // oprette en ny bruger
    public User registerUser(User user){
        if(repository.avaliableUserName(user.getUser())){
            throw new IllegalArgumentException("Brugernavnet findes allerede!");
        }
        if (repository.avaliableEmail(user.getEmail())) {
            throw new IllegalArgumentException("Emailen er allerede i brug!");
        }
        return repository.save(user);
    }

    // checker brugernavn og kode er korrekt
    public boolean login(String username, String password){
            User user = repository.findByUserName(username);
            if (user == null) return false;
            return user.getPassword().equals(password);
    }

    // find bruger gennem navn
    public User getUsername(String user){
        User user1 = repository.findByUserName(user);
        return user1;

    }

    // find bruger gennem deres email
    public User getEmail(String email){
        return repository.findByEmail(email);
    }

    //find bruger med deres Id
    public User getById(int id) {
        return repository.findById(id);
    }
}
                