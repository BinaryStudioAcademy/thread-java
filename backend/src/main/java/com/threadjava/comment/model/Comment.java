package com.threadjava.comment.model;

import com.threadjava.db.BaseEntity;
import com.threadjava.post.model.Post;
import com.threadjava.users.model.User;
import lombok.*;
import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "body", columnDefinition="TEXT")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;
}
