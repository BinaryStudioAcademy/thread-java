package com.threadjava.comment;

import com.threadjava.comment.model.CommentDetailsDto;
import com.threadjava.comment.model.CommentSaveDto;
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
    public CommentDetailsDto get(@PathVariable UUID id) {
        return commentService.getPostById(id);
    }

    @PostMapping
    public CommentDetailsDto post(@RequestBody CommentSaveDto commentDto) {
        return commentService.create(commentDto, getUserId());
    }
}
