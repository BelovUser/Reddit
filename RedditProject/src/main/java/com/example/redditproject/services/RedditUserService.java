package com.example.redditproject.services;

import com.example.redditproject.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedditUserService {

    private final RepositoryUser repositoryUser;

    @Autowired
    public RedditUserService(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }
}
