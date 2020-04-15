package com.threadjava.postReactions;

import com.threadjava.postReactions.dto.ReceivedPostReactionDto;
import com.threadjava.postReactions.dto.ResponsePostReactionDto;
import com.threadjava.postReactions.model.PostReaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostReactionMapper {
    PostReactionMapper MAPPER = Mappers.getMapper( PostReactionMapper.class );

    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "user.id", target = "userId")
    ResponsePostReactionDto reactionToPostReactionDto(PostReaction postReaction);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PostReaction dtoToPostReaction(ReceivedPostReactionDto postReactionDto);
}
