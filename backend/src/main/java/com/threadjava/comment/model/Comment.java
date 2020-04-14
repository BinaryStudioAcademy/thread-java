package com.threadjava.comment.model;

import com.threadjava.models.BaseEntity;
import com.threadjava.post.model.Post;
import com.threadjava.users.model.User;
import lombok.*;
import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "posts_id")
    private Post post;
}
