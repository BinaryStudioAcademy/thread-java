package com.threadjava.post;

import com.threadjava.models.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PostsRepository extends PagingAndSortingRepository<Post, UUID> {
}
