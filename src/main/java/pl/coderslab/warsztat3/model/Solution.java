package pl.coderslab.warsztat3.model;

import java.time.LocalDate;

public class Solution {

    public Solution() {
        this.id = 0;
    }

    public Solution(int id, LocalDate created, LocalDate updated, String description) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.description = description;
    }

    public Solution(int id, LocalDate updated, String title, String username) {
        this.id = id;
        this.updated = updated;
        this.title = title;
        this.username = username;
    }

    private int id;
    private LocalDate created;
    private LocalDate updated;
    private String description;
    private String title;
    private String username;

    public int getId() {
        return id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }
}
