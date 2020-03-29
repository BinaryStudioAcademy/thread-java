package com.threadjava.comment;

import com.threadjava.models.Comment;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
}