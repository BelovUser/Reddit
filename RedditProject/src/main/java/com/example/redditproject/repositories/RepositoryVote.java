package com.example.redditproject.repositories;

import com.example.redditproject.models.TrendPost;
import com.example.redditproject.models.Vote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryVote extends CrudRepository<Vote, Long> {
    List<Vote> findAllByVotedPostsOrderByDislike(TrendPost votedPost);
    List<Vote> findAllByVotedPostsOrderByLike(TrendPost votedPost);
}
