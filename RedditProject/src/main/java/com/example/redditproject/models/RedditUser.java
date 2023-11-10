package com.example.redditproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RedditUser {

    private String username;
    private String email;
    @Id
    private Long id;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
