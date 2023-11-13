package com.example.redditproject.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TrendPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PostId;
    private int likes = 0;
    private String title;
    private String url;
    private String date;
    @ManyToMany(mappedBy = "userPosts", cascade = CascadeType.ALL)
    private List<RedditUser> Users = new ArrayList<>();

    @ManyToMany(mappedBy = "votedPosts", cascade = CascadeType.ALL)
    private List<Vote> votedPosts = new ArrayList<>();

    public List<Vote> getVotedPosts() {
        return votedPosts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<RedditUser> getUsers() {
        return Users;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    public void setPostId(Long id) {
        this.PostId = id;
    }

    public Long getPostId() {
        return PostId;
    }
}
