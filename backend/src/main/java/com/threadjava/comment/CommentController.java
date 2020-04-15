package com.threadjava.comment;

import com.threadjava.comment.dto.CommentDetailsDto;
import com.threadjava.comment.dto.CommentSaveDto;
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
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentDetailsDto post(@RequestBody CommentSaveDto commentDto) {
        commentDto.setUserId(getUserId());
        return commentService.create(commentDto);
    }
}
