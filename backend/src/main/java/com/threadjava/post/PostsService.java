package com.threadjava.post;

import com.threadjava.models.Post;
import com.threadjava.models.PostReaction;
import com.threadjava.postReactions.PostReactionsRepository;
import com.threadjava.users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import static com.threadjava.auth.TokenService.getUserId;

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

    public List<PostDto> getAllPosts(Integer from, Integer count, UUID userId){
        var posts = postsCrudRepository.findAll();
        return StreamSupport.stream(posts.spliterator(), false)
                .map(x -> modelMapper.map(x, PostDto.class))
                .collect(Collectors.toList());
    }

    public PostDto getPostById(UUID id){
        var post = postsCrudRepository.findById(id).orElseThrow();
        return modelMapper.map(post, PostDto.class);
    }

    public PostDto create(PostDto postDto, UUID userId){
        Post post = modelMapper.map(postDto, Post.class);
        post.user =  usersRepository.findById(userId).get();
        Post postCreated = postsCrudRepository.save(post);
        return modelMapper.map(postCreated, PostDto.class);
    }

//    public PostReaction setReaction(PostReaction postReaction) {
////    const updateOrDelete = react => (react.isLike === isLike
////                ? postReactionsRepository.deleteById(react.id)
////                : postReactionsRepository.save(react.id, { isLike }));
//
//    var reaction =  postReactionsRepository.getPostReaction(getUserId(), postReaction.post.id);
//
//    const result = reaction
//                ? await updateOrDelete(reaction)
//        : await postReactionRepository.create({ userId, postId, isLike });
//
//        // the result is an integer when an entity is deleted
//        return Number.isInteger(result) ? {} : postReactionRepository.getPostReaction(userId, postId);
//    }
}
