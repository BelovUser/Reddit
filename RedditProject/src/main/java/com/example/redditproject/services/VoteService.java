package com.example.redditproject.services;

import com.example.redditproject.models.TrendPost;
import com.example.redditproject.models.Vote;
import com.example.redditproject.repositories.RepositoryVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private final RepositoryVote repositoryVote;

    @Autowired
    public VoteService(RepositoryVote repositoryVote) {
        this.repositoryVote = repositoryVote;
    }

    public void saveVote(Vote vote) {
        repositoryVote.save(vote);
    }

    public Vote getVoteById(Long voteId) {
        return repositoryVote.findById(voteId).orElse(null);
    }

    public void updateVote(Vote updatedVote) {
        if (repositoryVote.existsById(updatedVote.getId())) {
            repositoryVote.save(updatedVote);
        }
    }

    public void deleteVote(Long voteId) {
        repositoryVote.deleteById(voteId);
    }

    public List<Vote> getAllVotes() {
        return repositoryVote.findAll();
    }

    public List<Vote> findAllLikedVotedPost(List<TrendPost> posts){
        return repositoryVote.findAllByVotedPostsOrderByLike(posts);
    }

    public List<Vote> findAllDislikedVotedPost(List<TrendPost> posts){
        return repositoryVote.findAllByVotedPostsOrderByDislike(posts);
    }
}

