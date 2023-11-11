package com.example.redditproject.services;

import com.example.redditproject.models.RedditUser;
import com.example.redditproject.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedditUserService {

    private final RepositoryUser repositoryUser;

    @Autowired
    public RedditUserService(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public List<RedditUser> getAllUsers() {
        return repositoryUser.findAll();
    }
    public void saveUser(RedditUser user) {
        repositoryUser.save(user);
    }

    public void updateUser(RedditUser user) {
        repositoryUser.save(user);
    }

    public void deleteUser(Long userId) {
        repositoryUser.deleteById(userId);
    }

    public Optional<RedditUser> getById(Long userId){
        return repositoryUser.findById(userId);
    }

    public Optional<RedditUser> findUserByPostId(Long postId) {
        return repositoryUser.findAll().stream()
                .filter(user -> user.getUserPosts().stream()
                        .anyMatch(post -> post.getPostId().equals(postId)))
                .findFirst();
    }
}
