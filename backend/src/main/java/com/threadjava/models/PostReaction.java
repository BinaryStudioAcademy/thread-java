package com.threadjava.models;

import javax.persistence.*;

@Entity
@Table(name = "post_reaction")
public class PostReaction {

    @Column(name = "isLike")
    public Boolean isLike;
}
