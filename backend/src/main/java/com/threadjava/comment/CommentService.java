package com.threadjava.comment;

import com.threadjava.comment.dto.CommentDetailsDto;
import com.threadjava.comment.dto.CommentSaveDto;
import com.threadjava.comment.model.Comment;
import com.threadjava.post.PostsRepository;
import com.threadjava.users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CommentDetailsDto getPostById(UUID id) {
        var comment = commentRepository.findById(id).orElseThrow();
        return modelMapper.map(comment, CommentDetailsDto.class);
    }

    public CommentDetailsDto create(CommentSaveDto commentDto, UUID userId) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
//        comment.setUserId(userId);
//        comment.setPostId(commentDto.getPostId());
        Comment postCreated = commentRepository.save(comment);
        return modelMapper.map(postCreated, CommentDetailsDto.class);
    }
}
