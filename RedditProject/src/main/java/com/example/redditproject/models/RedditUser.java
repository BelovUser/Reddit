package com.example.redditproject.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RedditUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;
    @ManyToMany
    private List<TrendPost> userPosts = new ArrayList<>();

    @ManyToMany(mappedBy = "votedUsers", cascade = CascadeType.ALL)
    private List<Vote> votedPost = new ArrayList<>();

    public List<Vote> getVotedPost() {
        return votedPost;
    }

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

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }
}
