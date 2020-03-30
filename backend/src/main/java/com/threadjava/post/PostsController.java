package com.threadjava.post;


import com.threadjava.post.model.PostDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import static com.threadjava.auth.TokenService.getUserId;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public List<PostDetailsDto> get(@RequestParam(defaultValue="0") Integer from,
                                    @RequestParam(defaultValue="10") Integer count,
                                    @RequestParam(required = false) UUID userId) {
        return postsService.getAllPosts(from, count, userId);
    }

    @GetMapping("/{id}")
    public PostDetailsDto get(@PathVariable UUID id) {
        return postsService.getPostById(id);
    }

    @PostMapping
    public PostDetailsDto post(@RequestBody PostDetailsDto postDto) {
        //TODO: 'new_post', post// notify all users that a new post was created
        return postsService.create(postDto, getUserId());
    }

//    @PutMapping("/react")
//    public PostReaction setReaction(@RequestBody PostReaction postReaction){
    //TODO: notify a user if someone (not himself) liked his post
//        return postsService.setReaction(postReaction);
//    }
}
