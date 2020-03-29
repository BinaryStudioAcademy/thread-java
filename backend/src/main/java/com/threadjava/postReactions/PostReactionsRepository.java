package com.threadjava.postReactions;

import com.threadjava.models.PostReaction;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface PostReactionsRepository extends CrudRepository<PostReaction, UUID> {
//    @Query("SELECT " +
//            "    new com.path.to.SurveyAnswerStatistics(v.answer, COUNT(v)) " +
//            "FROM " +
//            "    Survey v " +
//            "GROUP BY " +
//            "    v.answer")
//    void getPostReaction(UUID userId, UUID id);
}