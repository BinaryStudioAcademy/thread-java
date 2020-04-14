package com.threadjava.postReactions;

import com.threadjava.post.PostMapper;
import com.threadjava.postReactions.dto.PostReactionDto;
import com.threadjava.postReactions.model.PostReaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostReactionMapper {
    PostReactionMapper MAPPER = Mappers.getMapper( PostReactionMapper.class );

    PostReactionDto postReactionToDto(PostReaction reaction);
}
