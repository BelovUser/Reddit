package com.example.redditproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrendPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int likes;
    private String title;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
