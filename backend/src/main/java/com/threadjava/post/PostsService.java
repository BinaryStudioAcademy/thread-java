package com.threadjava.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;
}
