package com.example.redditproject.repositories;

import com.example.redditproject.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVote extends CrudRepository<Vote, Long> {
}
