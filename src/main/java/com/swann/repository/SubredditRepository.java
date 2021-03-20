package com.swann.repository;

import com.swann.model.Subreddit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubredditRepository extends CrudRepository<Subreddit, Long> {
    Optional<Subreddit> findByName(String subredditName);
}
