package com.threadjava.post;

import com.threadjava.models.Post;
import com.threadjava.post.model.PostListDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostsRepository extends CrudRepository<Post, UUID> {

//    @Query("SELECT new com.threadjava.post.model.PostListDto(p.id)" +
//            ", p.body, 0, 0, 0, " +
//            "p.createdAt, new com.threadjava.image.ImageDto(i.id, i.link)) " +
//            "FROM Post p JOIN p.image i")
//    List<Post> findAll(@Param("userId")UUID userId, Pageable pageable);
    List<Post> findAll(Pageable pageable);
}
