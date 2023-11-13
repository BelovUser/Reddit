package com.example.redditproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vote {
    @Id
    private Long id;
    private int dislike = -1;
    private int like = 1;
    private int ignored = 0;

    @ManyToMany
    private List<RedditUser> votedUsers = new ArrayList<>();

    @ManyToMany
    private List<TrendPost> votedPosts = new ArrayList<>();


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
