package com.threadjava.post;

import com.threadjava.models.Post;
import com.threadjava.models.PostReaction;
import com.threadjava.post.model.PostDetailsDto;
import com.threadjava.post.model.PostListDto;
import com.threadjava.post.model.PostListModel;
import com.threadjava.post.model.ResponcePostReactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper MAPPER = Mappers.getMapper( PostMapper.class );

//    @Mapping(source = "numberOfSeats", target = "seatCount")
    PostDetailsDto postToPostDetailsDto(Post post);

    Post postDetailsDtoToPost(PostDetailsDto postDetailsDto);

    ResponcePostReactionDto reactionToPostReactionDto(PostReaction postReaction);

    PostListDto postListToPostListDto(PostListModel model);
}