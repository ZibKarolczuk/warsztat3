package pl.coderslab.warsztat3.model;

import java.time.LocalDate;

public class Users {

    public Users() {
        this.id = 0;
    }

    public Users(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Users(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private int id;
    private String username;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
