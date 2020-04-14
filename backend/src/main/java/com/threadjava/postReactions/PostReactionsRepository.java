package com.threadjava.postReactions;

import com.threadjava.postReactions.model.PostReaction;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostReactionsRepository extends CrudRepository<PostReaction, UUID> {
//    @Query("SELECT PostReaction " +
//            "FROM PostReaction reaction " +
//            "JOIN post ON post.id = reaction.posts_id " +
////            "WHERE reaction.user = :userId AND reaction.post = :postId " +
//            "GROUP BY reaction.id, post.id")
////            "LIMIT 1")
//    Optional<PostReaction> getPostReaction(@Param("userId") UUID userId, @Param("postId") UUID postId);
}