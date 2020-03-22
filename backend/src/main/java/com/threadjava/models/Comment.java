package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "body")
    @Getter @Setter private String body;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    @Getter @Setter private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "posts_id")
    @Getter @Setter private Post post;
}
