package com.example.redditproject.services;

import com.example.redditproject.repositories.RepositoryVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final RepositoryVote repositoryVote;

    @Autowired
    public VoteService(RepositoryVote repositoryVote) {
        this.repositoryVote = repositoryVote;
    }

    
}
