package com.threadjava.comment;

import com.threadjava.comment.model.CommentDetailsDto;
import com.threadjava.comment.model.CommentSaveDto;
import com.threadjava.models.Comment;
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

    public CommentDetailsDto getPostById(UUID id){
        var comment = commentRepository.findById(id).orElseThrow();
        return modelMapper.map(comment, CommentDetailsDto.class);
    }

    public CommentDetailsDto create(CommentSaveDto commentDto, UUID userId){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.user =  usersRepository.findById(userId).get();
        comment.post = postsRepository.findById(commentDto.postId).get();
        Comment postCreated = commentRepository.save(comment);
        return modelMapper.map(postCreated, CommentDetailsDto.class);
    }
}
