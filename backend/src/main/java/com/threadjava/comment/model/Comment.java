package com.threadjava.comment.model;

import com.threadjava.models.BaseEntity;
import com.threadjava.models.Post;
import com.threadjava.users.model.User;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "users_id")
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "posts_id")
    private Post post;

    @Column(name = "posts_id")
    private UUID postId;
}
