package com.threadjava.postReactions;

import com.threadjava.postReactions.model.PostReaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;

public interface PostReactionsRepository extends CrudRepository<PostReaction, UUID> {
    @Query("SELECT r " +
            "FROM PostReaction r " +
            "WHERE r.user.id = :userId AND r.post.id = :postId ")
    Optional<PostReaction> getPostReaction(@Param("userId") UUID userId, @Param("postId") UUID postId);
}