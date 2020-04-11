package com.threadjava.post;

import com.threadjava.models.*;
import com.threadjava.post.model.*;
import com.threadjava.postReactions.PostReactionDto;
import com.threadjava.postReactions.PostReactionsRepository;
import com.threadjava.users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PostReactionsRepository postReactionsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PostDetailsDto> getAllPosts(Integer from, Integer count, UUID userId) {
        var pageable = PageRequest.of(from/count, count, Sort.Direction.DESC, "createdAt");
        var posts = postsCrudRepository.findAll(pageable);
//        return posts;
        return StreamSupport.stream(posts.spliterator(), false).map(x -> modelMapper.map(x, PostDetailsDto.class))
                .collect(Collectors.toList());
    }

    public PostDetailsDto getPostById(UUID id) {
        var post = postsCrudRepository.findById(id).orElseThrow();
        return modelMapper.map(post, PostDetailsDto.class);
    }

    public PostDetailsDto create(PostDetailsDto postDto, UUID userId) {
        Post post = modelMapper.map(postDto, Post.class);
        post.user = usersRepository.findById(userId).get();
        Post postCreated = postsCrudRepository.save(post);
        return modelMapper.map(postCreated, PostDetailsDto.class);
    }

    public Optional<ResponcePostReactionDto> setReaction(UUID userId, ReceivedPostReactionDto postReactionDto) {

//        var reaction = postReactionsRepository.getPostReaction(userId, postReactionDto.postId);

//        if (reaction.isPresent()) {
//            var react = reaction.get();
//            if (react.isLike == postReactionDto.isLike) {
//                postReactionsRepository.deleteById(reaction.get().id);
//                return Optional.empty();
//            } else {
//                react.isLike = postReactionDto.isLike;
//                var result = postReactionsRepository.save(react);
//                return Optional.of(modelMapper.map(result, ResponcePostReactionDto.class));
//            }
//        } else {
            var postReaction = new PostReaction();
            postReaction.isLike = postReactionDto.isLike;
            postReaction.user = usersRepository.findById(userId).get();
            postReaction.post = postsCrudRepository.findById(postReactionDto.postId).get();
            var result =postReactionsRepository.save(postReaction);
            return Optional.of(modelMapper.map(result, ResponcePostReactionDto.class));
//        }
    }
}
