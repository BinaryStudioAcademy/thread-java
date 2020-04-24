package com.threadjava.post;

import com.threadjava.comment.CommentRepository;
import com.threadjava.post.dto.*;
import com.threadjava.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsCrudRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<PostListDto> getAllPosts(Integer from, Integer count, UUID userId) {
        var pageable = PageRequest.of(from / count, count);
        return postsCrudRepository
                .findAllPosts(userId, pageable)
                .stream()
                .map(PostMapper.MAPPER::postListToPostListDto)
                .collect(Collectors.toList());
    }

    public PostDetailsDto getPostById(UUID id) {
        var post = postsCrudRepository.findPostById(id)
                .map(PostMapper.MAPPER::postToPostDetailsDto)
                .orElseThrow();

        var comments = commentRepository.findAllByPostId(id)
                .stream()
                .map(PostMapper.MAPPER::commentToCommentDto)
                .collect(Collectors.toList());
        post.setComments(comments);

        return post;
    }

    public PostCreationResponseDto create(PostCreationDto postDto) {
        Post post = PostMapper.MAPPER.postDetailsDtoToPost(postDto);
        Post postCreated = postsCrudRepository.save(post);
        return PostMapper.MAPPER.postToPostCreationResponseDto(postCreated);
    }
}
