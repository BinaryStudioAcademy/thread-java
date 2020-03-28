package com.threadjava.post;

import com.threadjava.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostsRepository extends CrudRepository<Post, UUID> {
}
