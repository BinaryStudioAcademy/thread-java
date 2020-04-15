package com.threadjava.post;

import com.threadjava.image.ImageMapper;
import com.threadjava.post.dto.*;
import com.threadjava.post.model.Post;
import com.threadjava.postReactions.model.PostReaction;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(uses = { ImageMapper.class })
public abstract class PostMapper {

    public static final PostMapper MAPPER = Mappers.getMapper( PostMapper.class );

    public abstract PostDetailsDto postToPostDetailsDto(PostDetailsQueryResult post);

    public abstract PostDetailsDto postToPostDetailsDto(Post post);

    @Mapping(source = "user.id", target = "userId")
    public abstract PostCreationResponseDto postToPostCreationResponseDto(Post post);

    @Mapping(source = "imageId", target = "image.id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    public abstract Post postDetailsDtoToPost(PostCreationDto postDetailsDto);

    @AfterMapping
    public Post doAfterMapping(@MappingTarget Post entity) {
        if (entity != null && entity.getImage().getId() == null) {
            entity.setImage(null);
        }
        return entity;
    }

    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "user.id", target = "userId")
    public abstract ResponcePostReactionDto reactionToPostReactionDto(PostReaction postReaction);

    public abstract PostListDto postListToPostListDto(PostListQueryResult model);
}