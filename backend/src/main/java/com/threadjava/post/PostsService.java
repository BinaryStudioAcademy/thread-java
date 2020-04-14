package com.threadjava.post;

import com.threadjava.post.dto.*;
import com.threadjava.post.model.Post;
import com.threadjava.postReactions.PostReactionsRepository;
import com.threadjava.postReactions.model.PostReaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;
    @Autowired
    private PostReactionsRepository postReactionsRepository;

    public List<PostListDto> getAllPosts(Integer from, Integer count, UUID userId) {
        var pageable = PageRequest.of(from / count, count);
        return postsCrudRepository
                .findAllPosts(userId, pageable)
                .stream()
                .map(PostMapper.MAPPER::postListToPostListDto)
                .collect(Collectors.toList());
    }

    public PostDetailsDto getPostById(UUID id) {
        return postsCrudRepository.findById(id)
                .map(PostMapper.MAPPER::postToPostDetailsDto)
                .orElseThrow();
    }

    public PostCreationResponseDto create(PostCreationDto postDto) {
        Post post = PostMapper.MAPPER.postDetailsDtoToPost(postDto);
        Post postCreated = postsCrudRepository.save(post);
        return PostMapper.MAPPER.postToPostCreationResponseDto(postCreated);
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
//            postReaction.isLike = postReactionDto.isLike;
//            postReaction.user = usersRepository.findById(userId).get();
//            postReaction.post = postsCrudRepository.findById(postReactionDto.postId).get();
            var result = postReactionsRepository.save(postReaction);
            return Optional.of(PostMapper.MAPPER.reactionToPostReactionDto(result));
//        }
    }
}
