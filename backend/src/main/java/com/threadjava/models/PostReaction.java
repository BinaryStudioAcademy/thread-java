package com.threadjava.models;

import javax.persistence.*;

@Entity
@Table(name = "post_reaction")
public class PostReaction extends BaseEntity {

    @Column(name = "isLike")
    public Boolean isLike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    public User user;
}
