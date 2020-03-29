package com.threadjava.post;


import com.threadjava.models.Post;
import com.threadjava.models.PostReaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.threadjava.auth.TokenService.getUserId;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public List<PostDto> get(@RequestParam(defaultValue="10") Integer count, @RequestParam(defaultValue="0") Integer from) {
        return postsService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto get(@PathVariable UUID id) {
        return postsService.getPostById(id);
    }

    @PostMapping
    public PostDto post(@RequestBody PostDto postDto) {
        return postsService.create(postDto);
    }

//    @PutMapping("/react")
//    public PostReaction setReaction(@RequestBody PostReaction postReaction){
//        return postsService.setReaction(postReaction);
//    }
}
