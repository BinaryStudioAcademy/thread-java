package com.threadjava.post;

import com.threadjava.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;

    public Iterable<Post> findAll(){
        return postsCrudRepository.findAll();
    }

    public Post create(Post entity){
        return postsCrudRepository.save(entity);
    }
}
