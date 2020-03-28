package com.threadjava.post;

import com.threadjava.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;

    public Iterable<Post> getAllPosts(){
        return postsCrudRepository.findAll();
    }

    public Post getPostById(UUID id){
        return postsCrudRepository.findById(id).orElseThrow();
    }

    public Post create(Post entity){
        return postsCrudRepository.save(entity);
    }
}
