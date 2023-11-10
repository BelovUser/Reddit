package com.example.redditproject.repositories;

import com.example.redditproject.models.RedditUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends ListCrudRepository<RedditUser,Long> {
}
