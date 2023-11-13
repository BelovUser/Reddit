package com.example.redditproject.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.redditproject.models.TrendPost;
import com.example.redditproject.repositories.RepositoryTrend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrendService {

    private final RepositoryTrend repositoryTrend;
    @Autowired
    public TrendService(RepositoryTrend repositoryTrend) {
        this.repositoryTrend = repositoryTrend;
    }

    public Iterable<TrendPost> getTrendingPosts() {
        return repositoryTrend.findAll();
    }

    public void saveTrendPost(TrendPost trendPost) {
        repositoryTrend.save(trendPost);
    }

    public Optional<TrendPost> getTrendPostById(Long postId) {
        return repositoryTrend.findById(postId);
    }

    public List<TrendPost> getPostsSortedByLikes(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repositoryTrend.findAllByOrderByLikesDesc(pageable);
    }

    public void deleteById(Long postId) {
        repositoryTrend.deleteById(postId);
    }
}
