package com.threadjava.comment;

import com.threadjava.models.Comment;
import com.threadjava.users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import static com.threadjava.auth.TokenService.getUserId;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CommentDto getPostById(UUID id){
        var comment = commentRepository.findById(id).orElseThrow();
        return modelMapper.map(comment, CommentDto.class);
    }

    public CommentDto create(CommentDto postDto, UUID userId){
        Comment comment = modelMapper.map(postDto, Comment.class);
        comment.user =  usersRepository.findById(userId).get();
        Comment postCreated = commentRepository.save(comment);
        return modelMapper.map(postCreated, CommentDto.class);
    }
}
