package com.threadjava.users;

import com.threadjava.post.PostMapper;
import com.threadjava.users.dto.UserDetailsDto;
import com.threadjava.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper( UserMapper.class );

    UserDetailsDto userToUserDetailsDto(User user);
}
