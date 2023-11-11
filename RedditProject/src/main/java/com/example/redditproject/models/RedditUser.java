package com.example.redditproject.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RedditUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @ManyToMany
    private List<TrendPost> userPosts = new ArrayList<>();

    public List<TrendPost> getUserPosts() {
        return userPosts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
