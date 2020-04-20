package com.threadjava.post;

import com.threadjava.comment.model.Comment;
import com.threadjava.image.ImageMapper;
import com.threadjava.post.dto.*;
import com.threadjava.post.model.Post;
import com.threadjava.users.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(uses = { ImageMapper.class })
public abstract class PostMapper {
    public static final PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "comments", ignore = true)
    public abstract PostDetailsDto postToPostDetailsDto(PostDetailsQueryResult post);

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

    public abstract PostListDto postListToPostListDto(PostListQueryResult model);

    @Mapping(source = "avatar", target = "image")
    public abstract PostUserDto postUserToPostUserDto(User model);

    public abstract PostCommentDto commentToCommentDto(Comment comment);
}