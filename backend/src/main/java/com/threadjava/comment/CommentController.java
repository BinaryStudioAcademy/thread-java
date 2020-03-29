package com.threadjava.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import static com.threadjava.auth.TokenService.getUserId;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public CommentDto get(@PathVariable UUID id) {
        return commentService.getPostById(id);
    }

    @PostMapping
    public CommentDto post(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto, getUserId());
    }
}
