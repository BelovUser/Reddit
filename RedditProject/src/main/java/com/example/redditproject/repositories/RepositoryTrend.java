package com.example.redditproject.repositories;

import com.example.redditproject.models.TrendPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTrend extends CrudRepository<TrendPost, Long> {
}
