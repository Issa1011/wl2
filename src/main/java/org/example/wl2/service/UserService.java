package org.example.wl2.service;

import org.example.wl2.model.UserModel;
import org.example.wl2.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo repository;

    public UserService(UserRepo repository){
        this.repository = repository;
    }

    public void registerUser(UserModel user){
        if(repository.avaliableUserName(user.getUser())){
            throw new IllegalArgumentException("Username already exists");
        }
        repository.save(user);
    }

    public boolean login(String username, String passwords){
        try{
            UserModel user = repository.findByUserName(username);
            return user.getPassword().equals(passwords);
        } catch (Exception e) {
            return false;
        }

    }

    public UserModel getUsername(String user){
        return repository.findByUserName(user);

    }

    public UserModel getEmail(String email){
        return repository.findByEmail(email);
    }

    public boolean confirmUser(String username){
        return repository.avaliableUserName(username);
    }

    public void saveUser(UserModel model){
       repository.save(model);
    }

}
                