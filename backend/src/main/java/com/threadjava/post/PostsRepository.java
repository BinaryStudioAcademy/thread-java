package com.threadjava.post;

import com.threadjava.models.Post;
import com.threadjava.post.model.PostListDto;
import com.threadjava.post.model.PostListModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostsRepository extends CrudRepository<Post, UUID> {

    @Query("SELECT new com.threadjava.post.model.PostListModel(p.id, p.body, " +
            "(SELECT COALESCE(SUM(CASE WHEN pr.isLike = TRUE THEN 1 ELSE 0 END), 0) FROM p.reactions pr WHERE pr.post = p), " +
            "(SELECT COALESCE(SUM(CASE WHEN pr.isLike = FALSE THEN 1 ELSE 0 END), 0) FROM p.reactions pr WHERE pr.post = p), " +
            "(SELECT COUNT(*) FROM p.comments), " +
            "p.createdAt, i, p.user) " +
            "FROM Post p " +
            "LEFT JOIN p.image i " +
            "WHERE ( cast(:userId as string) is null OR p.user.id = :userId) " +
            "order by p.createdAt desc" )
    List<PostListModel> findAllPosts(@Param("userId") UUID userId, Pageable pageable);
}