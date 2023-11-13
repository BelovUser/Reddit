package com.example.redditproject.models;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int dislike = -1;
    private int like = 1;
    private int ignored = 0;

    @ManyToMany
    private List<RedditUser> votedUsers = new ArrayList<>();

    @ManyToMany
    private List<TrendPost> votedPosts = new ArrayList<>();

    public List<RedditUser> getVotedUsers() {
        return votedUsers;
    }

    public List<TrendPost> getVotedPosts() {
        return votedPosts;
    }

    public Long getId() {
        return id;
    }

    public int getDislike() {
        return dislike;
    }

    public int getLike() {
        return like;
    }

    public int getIgnored() {
        return ignored;
    }
}
