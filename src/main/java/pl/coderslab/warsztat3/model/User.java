package pl.coderslab.warsztat3.model;

import java.time.LocalDate;

public class User {

    public User(int id, LocalDate updated, String title) {
        this.id = id;
        this.updated = updated;
        this.title = title;
    }

    public User(int id, String username, String email, String group, int user_group_id){
        this.id = id;
        this.username = username;
        this.email = email;
        this.group = group;
        this.user_group_id = user_group_id;
    }

    private int id;
    private LocalDate updated;
    private String title;

    private String username;
    private String email;
    private String group;
    private int user_group_id;

    public int getId() {
        return id;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public int getUser_group_id() {
        return user_group_id;
    }

}
