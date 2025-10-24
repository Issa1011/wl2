package org.example.wl2.model;

public class UserModel {
    private int id;
    private String user;
    private String email;
    private String password;

    public UserModel(int id, String user, String email, String password){
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public UserModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
